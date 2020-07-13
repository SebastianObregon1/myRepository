import groovy.sql.Sql
import groovy.json.JsonSlurper

class dataBuilder {

    //Attributes for DB Connection
    def dbSchema
    def dbServer
    def dbUser
    def dbPassword
    def dbDriver
    def dbUrl
    def sql
    def pfxEnv

    //Attributes for API Connection
    def loginTarget
    def urlTarget
    def rowLimit
    def criteria
    def date

    void setup(String env) {
        //Attributes for DB Connection
        dbSchema = "Local"
        dbServer = "Localhost"
        dbUser = "sobregon"
        dbPassword = "sobregon2"
        dbDriver = "oracle.jdbc.driver.OracleDriver"
        dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"
        pfxEnv = env

        //Attributes for API Connection
        if ( pfxEnv == "ad-na2" ) {
            loginTarget = 'BASIC YWQtbmEyL3NlYmFzdGlhbi5vYnJlZ29uMUBhdmVyeWRlbm5pc29uLmNvbTpvYnJlZ29uMw=='
            urlTarget = 'https://ad.pricefx.eu/pricefx/ad-na2/'
            //urlTarget = 'https://147.135.11.192:443/pricefx/ad-na2/'
        } else if ( pfxEnv == "ad-na-qa2") {
            loginTarget = 'BASIC YWQtbmEtcWEyL3NlYmFzdGlhbi5vYnJlZ29uMUBhdmVyeWRlbm5pc29uLmNvbS50ZXN0Om9icmVnb24x' //ad-na-qa2
            urlTarget = 'https://ad.pricefx.eu/pricefx/ad-na-qa2/' //ad-na-qa2
        } else {
            loginTarget = 'BASIC YWQtbmEtdWF0Mi9zZWJhc3RpYW4ub2JyZWdvbjFAYXZlcnlkZW5uaXNvbi5jb20uc2l0MjpvYnJlZ29uMQ==' //ad-na-uat2
            urlTarget = 'https://staging.pricefx.eu/pricefx/ad-na-uat2/' //ad-na-uat2
        }

        println "Connecting to ${pfxEnv}"
        //println "URL: ${urlTarget}"

        date = new Date()

        rowLimit = 30000
        criteria = "\"data\" : {\"_constructor\":\"AdvancedCriteria\", \"operator\": \"and\", \"criteria\":[ { \"fieldName\":\"attribute14\", \"operator\":\"greaterThan\", \"value\":"
        criteria = criteria + "\"" + date[Calendar.YEAR].toString() + "-" + String.format ( "%02d", (date[Calendar.MONTH] +1)) + "-" + String.format ( "%02d", date[Calendar.DATE] ) + "\""
        //criteria = criteria + "\"" + "2019" + "-" + "08" + "-" + "06" + "\""
        criteria = criteria + ", \"_constructor\":\"AdvancedCriteria\" }  ] } "

    }


    void openDBConnection() {
        sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
    }

    void closeDBConnection() {
        sql.close()
    }

    void pullQuotesFromEBS() {

        if ( pfxEnv == "ad-na2" ) {
            sql.execute("BEGIN\n" +
                    "    xxso.xxso_r_recon_build;\n" +
                    "    END;")

        } else if ( pfxEnv == "ad-na-qa2") {
            sql.execute("BEGIN\n" +
                    "    xxso.xxso_r_recon_build_uat;\n" +
                    "    END;")
        } else {
        }

    }

    void testAPI() {

        def insertString;

        def connection = new URL(url + 'customermanager.fetch/*/CX/Pricelist?isc_dataFormat=json').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write('{ "operationType":"fetch", "startRow":0, "endRow":1 ' + ',' + criteria + ' }')
        httpRequestBodyWriter.close()

        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        println api.response.totalRows

        api.response.data.each {
            println it.name

        }

        connection.disconnect()

    }

    void pullQuotes() {

        def insertString;

        def connection = new URL(urlTarget + 'customermanager.fetch/*/CX/Pricelist?isc_dataFormat=json').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginTarget)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write('{ "operationType":"fetch", "startRow":0, "endRow":1' + ',' + criteria + ' }')
        httpRequestBodyWriter.close()

        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        def totalRows = api.response.totalRows as Integer

        println "Total Rows: ${api.response.totalRows}"
        //println criteria


        // Clear table
        sql.execute("DELETE FROM XXSO_R_PFXQUOTES")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit /* - 1 */

            println "${new Date().toString()} - Processing from ${i} to ${x}"

            this.insertQuotes(i,x)
        }

        connection.disconnect()

    }

    void insertQuotes(int from, int to) {

        def insertString;

        def connection = new URL(urlTarget + 'customermanager.fetch/*/CX/Pricelist?isc_dataFormat=json').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginTarget)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to} " + "," + criteria + " }")

        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_R_PFXQUOTES VALUES ("
                insertString = insertString + "'" + it.customerId + "'" + "," //Customer_ID
                insertString = insertString + "'" + it.attribute1 + "'" + "," //Active
                insertString = insertString + "'" + it.attribute2 + "'" + "," //Quote
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update Date
                insertString = insertString + "'" + it.attribute4 + "'" + "," //QuoteType
                insertString = insertString + "'" + it.attribute30 + "'" + "," //QuoteStatus
                insertString = insertString + "'" + it.attribute13 + "'" + "," //EffectiveDate
                insertString = insertString + "'" + it.attribute14 + "'" + "," //ExpiryDate
                insertString = insertString + "'" + it.attribute31 + "'" + "," //OriginalExpirationDate
                insertString = insertString + "'" + it.attribute6 + "'" + "," //CustomerNumber
                insertString = insertString + "'" + it.attribute5?.replace("'"," ")?.replace("\""," ") + "'" + "," //CustomerName
                insertString = insertString + "'" + it.attribute8 + "'" + "," //Item
                insertString = insertString + "'" + it.attribute24 + "'" + "," //SpecDesc
                insertString = insertString + it.attribute11 + "," //Price
                insertString = insertString + "'" + it.attribute12 + "'" + "," //Currency
                insertString = insertString + "'" + it.attribute15 + "'" + "," //UOM
                insertString = insertString + "'" + it.attribute20 + "'" + "," //ProjectNumber
                //def ternaryOutput = (sampleText != null) ? sampleText : 'Hello Groovy!'
                //insertString = insertString + "'" + it.attribute18?.replace("'"," ")?.replace(","," ")?.replace("\""," ") + "'" + "," //ProjectName
                if ( it.attribute18 != null) {
                    insertString = insertString + "'" + it.attribute18?.replace("'"," ")?.replace(","," ")?.replace("\""," ") + "'" + "," //ProjectName
                } else {
                    insertString = insertString + "'" + "'" + ","
                }
                insertString = insertString + "'" + it.attribute10 + "'" + "," //BusinessUnit
                insertString = insertString + "'" + it.attribute35 + "'" + "," //PricingSubGroup
                insertString = insertString + "'" + it.attribute7 + "'" + "," //NationalAccountNumber
                insertString = insertString + "'" + it.attribute9 + "'" + "," //ItemType
                insertString = insertString + "'" + (it.attribute25?:"") + "'" + "," //SpecDesc2
                insertString = insertString + it.attribute40 + "," //CustomerTierPercentage
                insertString = insertString + it.attribute36 + "," //QuoteDiscountPercentage
                insertString = insertString + "'" + (it.attribute16?:"") + "'" + "," //FreightRates
                insertString = insertString + "'" + (it.attribute17?:"") + "'" + "," //FreightTerms
                insertString = insertString + "'" + it.attribute19?.replace("'"," ")?.replace("\""," ")?.replace(","," ") + "'" + "," //QuoteComment
                insertString = insertString + "'" + it.attribute22 + "'" + "," //MOQ
                insertString = insertString + "'" + it.attribute21 + "'" + "," //ApplyQtyBreakStr
                insertString = insertString + "'" + it.attribute23 + "'" + "," //ShortRollWaive
                insertString = insertString + "'" + it.attribute26 + "'" + "," //TrimWave
                insertString = insertString + "'" + it.attribute37 + "'" + "," //SheetingWaive
                insertString = insertString + "'" + (it.attribute27?:"") + "'" + "," //LifeCyclePhase
                insertString = insertString + "'" + it.attribute28 + "'" + "," //Length
                insertString = insertString + it.attribute29 + "," //TrimMax
                insertString = insertString + "'" + it.attribute32 + "'" + "," //SystemAddedDate
                insertString = insertString + "'" + it.attribute33?.replace("'"," ")?.replace("\""," ")?.replace(","," ") + "'" + "," //SystemUpdateReason
                insertString = insertString + "'" + it.attribute34?.replace("'"," ")?.replace("\""," ")?.replace(","," ") + "'" + "," //ReasonForManualPriceChange
                insertString = insertString + "'" + it.attribute38 + "'" + "," //LifeCycleStatus
                insertString = insertString + "'" + ( it.attribute39?.replace("'"," ")?.replace("\""," ")?.replace(","," ")?:"" ) + "'" + "," //QuoteDescription
                insertString = insertString + "'" + it.attribute41 + "'" + "," //UpdateOnlyThisCustomer
                insertString = insertString + "'" + it.attribute42 + "'" + "," //QuoteUniqueId
                insertString = insertString + "'" + it.attribute43 + "'" + "," //ApprovedBy
                insertString = insertString + "'" + it.attribute44 + "'" + "," //ApprovedDate
                insertString = insertString + "'" + it.attribute45 + "'" + "," //Name_w/o_Revision
                insertString = insertString + "'" + (it.attribute46?:"") + "'" + "," //ProductStrategy
                insertString = insertString + "'" + it.attribute3 + "'" + "," //LineItemId
                insertString = insertString + "'" + (it.attribute47?:"") + "'" + "," //Attr. 47
                insertString = insertString + "'" + (it.attribute48?:"") + "'" + "," //PricelistId
                insertString = insertString + "'" + (it.attribute49?:"") + "'" + "," //Attr. 49
                insertString = insertString + "'" + (it.attribute50?:"") + "'" //Attr. 50
                insertString = insertString+ ")"

                sql.executeInsert(insertString)

                //stmt.addBatch(insertString)

            } // api.response.data.each

            //stmt.executeBatch()

        //} ) // stmt

        connection.disconnect()


    }

    void pullProducts() {

        def insertString;

        def connection = new URL(urlTarget + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginTarget)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write('{ "operationType":"fetch", "startRow":0, "endRow":1  }')
        httpRequestBodyWriter.close()

        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        def totalRows = api.response.totalRows as Integer

        println "Total Rows: ${api.response.totalRows}"

        connection.disconnect()

        // Clear table
        sql.execute("DELETE FROM XXSO_R_PFXITEMMASTER")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit /* - 1 */
            println "Processing from ${i} to ${x}"
            this.insertProducts(i,x)
        }

    }

    void insertProducts(int from, int to) {

        def insertString;

        def connection = new URL(urlTarget + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginTarget)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_R_PFXITEMMASTER VALUES ("
                insertString = insertString + "'" + it.sku?.replace("'"," ")?.replace("\""," ") + "'" + "," //Product_ID
                insertString = insertString + "'" + it.label?.replace("'"," ")?.replace("\""," ") + "'" + "," //SOLD_ITEM_DESC
                insertString = insertString + "'" + it.unitOfMeasure + "'" + "," //SOURCE_SYSTEM_CD
                insertString = insertString + "'" + it.currency + "'" + "," //SFDC_IDENTIFIER
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update
                insertString = insertString + "'" + (it.formulaName?:"") + "'" + "," //Pricing logic
                insertString = insertString + "'" + (it.attribute1?:"") + "'" + "," //SOURCE_SUB_SYSTEM_CD
                insertString = insertString + "'" + (it.attribute2?:"") + "'" + "," //EXTRACT_ID
                insertString = insertString + "'" + it.attribute3?.replace("'"," ")?.replace("\""," ") + "'" + "," //SPEC_DESC
                insertString = insertString + "'" + it.attribute4 + "'" + "," //SPEC_CD
                insertString = insertString + "'" + it.attribute5 + "'" + "," //PROD_LINE_TEAM_CD
                insertString = insertString + "'" + it.attribute6 + "'" + "," //Pressure_Sensitive
                insertString = insertString + "'" + it.attribute7 + "'" + "," //PROD_LINE_TEAM_DESC
                insertString = insertString + "'" + it.attribute8 + "'" + "," //PROD_LINE_CD
                insertString = insertString + "'" + it.attribute9?.replace("'"," ")?.replace("\""," ") + "'" + "," //PROD_LINE_DESC
                insertString = insertString + "'" + it.attribute10 + "'" + "," //PROD_GROUP_CD
                insertString = insertString + "'" + it.attribute11?.replace("'"," ")?.replace("\""," ") + "'" + "," //PROD_GROUP_DESC
                insertString = insertString + "'" + it.attribute12 + "'" + "," //ITEM_STOCK_TYPE_CD
                insertString = insertString + "'" + (it.attribute13?.replace("'"," ")?.replace("\""," ")?:"") + "'" + "," //ITEM_STOCK_TYPE_DESC
                insertString = insertString + "'" + it.attribute14 + "'" + "," //ITEM_STATUS_CD
                insertString = insertString + "'" + it.attribute15?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_STATUS_DESC
                insertString = insertString + "'" + it.attribute16 + "'" + "," //ITEM_GROUP_CD
                insertString = insertString + "'" + it.attribute17?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_GROUP_DESC
                insertString = insertString + "'" + (it.attribute18?.replace("'"," ")?.replace("\""," ")?:"") + "'" + "," //ITEM_2_DESC
                insertString = insertString + "'" + it.attribute19 + "'" + "," //SUB_PROD_LINE_TEAM_CD
                insertString = insertString + "'" + it.attribute20?.replace("'"," ") + "'" + "," //SUB_PROD_LINE_TEAM_DESC
                insertString = insertString + "'" + it.attribute21 + "'" + "," //ITEM_BASE_UOM_CD
                insertString = insertString + "'" + (it.attribute22?:"") + "'" + "," //GRS_PROD_TECH_CD
                insertString = insertString + "'" + (it.attribute23?.replace("'"," ")?.replace("\""," ")?:"") + "'" + "," //GRS_PROD_TECH_DESC
                insertString = insertString + "'" + it.attribute24 + "'" + "," //GRS_MAJOR_PROD_GROUP_CD
                insertString = insertString + "'" + (it.attribute25?.replace("'"," ")?.replace("\""," ")?:"" )+ "'" + "," //GRS_MAJOR_PROD_GROUP_DESC
                insertString = insertString + "'" + it.attribute26 + "'" + "," //SOLD_ITEM_CD
                insertString = insertString + "'" + it.attribute27 + "'" + "," //Ready For Pricing
                insertString = insertString + "'" + it.attribute28 + "'" + "," //Pricing Sub-Group
                insertString = insertString + "'" + (it.attribute29?:"") + "'" + "," //Pattern Gum
                insertString = insertString + "'" + it.attribute30 + "'" //Attr. 30
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        //} )

        connection.disconnect()

    }

}
