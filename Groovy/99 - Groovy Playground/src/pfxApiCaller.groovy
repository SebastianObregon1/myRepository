import groovy.sql.Sql
import groovy.json.JsonSlurper

class pfxApiCaller {

    //Attributes for DB Connection
    def dbSchema = "Local"
    def dbServer = "Localhost"
    def dbUser = "sobregon"
    def dbPassword = "sobregon2"
    def dbDriver = "oracle.jdbc.driver.OracleDriver"
    def dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"
    def sql

    //Attributes for API Connection
    def login = 'BASIC YWQtbmEyL3NlYmFzdGlhbi5vYnJlZ29uMUBhdmVyeWRlbm5pc29uLmNvbTpvYnJlZ29uMg==' /* ad-na2 obregon2 */
    def loginSrc = 'BASIC YWQtbmEvc2ViYXN0aWFuLm9icmVnb25AYXZlcnlkZW5uaXNvbi5jb206b2JyZWdvbjE=' /* ad-na obregon1 */
    def url = 'https://ad.pricefx.eu/pricefx/ad-na2/'
    def urlSrc = 'https://ad.pricefx.eu/pricefx/ad-na/'
    def urlPX = 'https://ad.pricefx.eu/pricefx/ad-na2/productmanager.fetch/*/PX/'
    def urlPXSrc = 'https://ad.pricefx.eu/pricefx/ad-na/productmanager.fetch/*/PX/'
    def rowLimit = 15000

    void openDBConnection() {
        sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
    }

    void closeDBConnection() {
        sql.close()
    }

    void testAPI() {

        def insertString;

        def connection = new URL(url + 'fetch/C').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write('{ "operationType":"fetch", "startRow":0, "endRow":1  }')
        httpRequestBodyWriter.close()

        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        println api.response.totalRows

        api.response.data.each {
            println it.name

        }

        connection.disconnect()

    }

    void pullCustomers() {

        def insertString;

        def connection = new URL( url + 'fetch/C').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
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
        sql.execute("DELETE FROM XXSO_M_PFXCUSTOMERMASTER")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertCustomers(i,x)
        }


    }

    void insertCustomers(int from, int to) {

        def insertString;

        def connection = new URL(url + 'fetch/C').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch(3) { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_PFXCUSTOMERMASTER VALUES ("
                insertString = insertString + "'" + it.customerId + "'" + "," //CustomerId 1
                insertString = insertString + "'" + it.name.replace("'", "").replace(",", "") + "'" + "," //Company Name 2
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update 3
                insertString = insertString + "'" + it.attribute1 + "'" + "," //SFDC Identifier 4
                insertString = insertString + "'" + it.attribute2 + "'" + "," //Customer Num CD 5
                insertString = insertString + "'" + it.attribute3 + "'" + "," // Bill to state CD 6
                insertString = insertString + "'" + it.attribute4 + "'" + "," // Bill to Zip CD 7
                insertString = insertString + "'" + it.attribute5 + "'" + "," // Source System CD 8
                insertString = insertString + "'" + it.attribute6 + "'" + "," //Sales Disctrict CD 9
                insertString = insertString + "'" + it.attribute7 + "'" + "," //Sales Team CD 10
                insertString = insertString + "'" + it.attribute8?.replace("'", "") + "'" + "," //Sales Team Desc 11
                insertString = insertString + "'" + it.attribute9 + "'" + "," //National Account Num CD 12
                insertString = insertString + "''" + "," //Ship to zip cd 13
                insertString = insertString + "''" + "," //Ship to country desc 14
                insertString = insertString + "''" + "," //Distributor CD 15
                insertString = insertString + "'" + it.attribute13 + "'" + "," //Customer Status CD 16
                insertString = insertString + "'" + it.attribute14 + "'" + "," //LPM Meu Desc 17
                insertString = insertString + "'" + it.attribute15 + "'" + "," //Graphics Channel Desc 18
                insertString = insertString + "'" + it.attribute16 + "'" + "," //Division Level 19
                insertString = insertString + "'" + it.attribute17?.replace("'", "") + "'" + "," //Bill to city CD 20
                insertString = insertString + "'" + it.attribute18 + "'" + "," //Account External ID 21
                insertString = insertString + "'" + it.attribute19 + "'" + "," //Customer Priority CD 22
                insertString = insertString + "''" + "," //Ship to State CD 23
                insertString = insertString + "'" + it.attribute21 + "'" + "," //Bill to Country Desc 24
                insertString = insertString + "'" + it.attribute22 + "'" + "," //Freight Term 25
                insertString = insertString + "''" + "," //Ship to Address 26
                insertString = insertString + "'" + it.attribute24?.replace("'", "") + "'" + "," //Bill to Address 27
                insertString = insertString + "''" + "," //Ship to City Cd 28
                insertString = insertString + "'" + it.attribute26 + "'" + "," //Attr26 29
                insertString = insertString + "'" + it.attribute27 + "'" + "," //Attr27 30
                insertString = insertString + "''" + "," //Attr28 31
                insertString = insertString + "''" + "," //Attr29 32
                insertString = insertString + "''"//Attr30 33
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }

            //stmt.executeBatch()

        // } //stmt

        connection.disconnect()

    }

    void pullCustomersSrc() {

        def insertString;

        def connection = new URL( urlSrc + 'fetch/C').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
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
        sql.execute("DELETE FROM XXSO_M_PFXCUSTOMERMASTER_SRC")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertCustomersSrc(i,x)
        }


    }

    void insertCustomersSrc(int from, int to) {

        def insertString;

        def connection = new URL(urlSrc + 'fetch/C').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_PFXCUSTOMERMASTER_SRC VALUES ("
                insertString = insertString + "'" + it.customerId + "'" + "," //CustomerId 1
                insertString = insertString + "'" + it.name.replace("'", "").replace(",", "") + "'" + "," //Company Name 2
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update 3
                insertString = insertString + "'" + it.attribute1 + "'" + "," //SFDC Identifier 4
                insertString = insertString + "'" + it.attribute2 + "'" + "," //Customer Num CD 5
                insertString = insertString + "'" + it.attribute3 + "'" + "," // Bill to state CD 6
                insertString = insertString + "'" + it.attribute4 + "'" + "," // Bill to Zip CD 7
                insertString = insertString + "'" + it.attribute5 + "'" + "," // Source System CD 8
                insertString = insertString + "'" + it.attribute6 + "'" + "," //Sales Disctrict CD 9
                insertString = insertString + "'" + it.attribute7 + "'" + "," //Sales Team CD 10
                insertString = insertString + "'" + it.attribute8?.replace("'", "") + "'" + "," //Sales Team Desc 11
                insertString = insertString + "'" + it.attribute9 + "'" + "," //National Account Num CD 12
                insertString = insertString + "''" + "," //Ship to zip cd 13
                insertString = insertString + "''" + "," //Ship to country desc 14
                insertString = insertString + "''" + "," //Distributor CD 15
                insertString = insertString + "'" + it.attribute13 + "'" + "," //Customer Status CD 16
                insertString = insertString + "'" + it.attribute14 + "'" + "," //LPM Meu Desc 17
                insertString = insertString + "'" + it.attribute15 + "'" + "," //Graphics Channel Desc 18
                insertString = insertString + "'" + it.attribute16 + "'" + "," //Division Level 19
                insertString = insertString + "'" + it.attribute17?.replace("'", "") + "'" + "," //Bill to city CD 20
                insertString = insertString + "'" + it.attribute18 + "'" + "," //Account External ID 21
                insertString = insertString + "'" + it.attribute19 + "'" + "," //Customer Priority CD 22
                insertString = insertString + "''" + "," //Ship to State CD 23
                insertString = insertString + "'" + it.attribute21 + "'" + "," //Bill to Country Desc 24
                insertString = insertString + "'" + it.attribute22 + "'" + "," //Freight Term 25
                insertString = insertString + "''" + "," //Ship to Address 26
                insertString = insertString + "'" + it.attribute24?.replace("'", "") + "'" + "," //Bill to Address 27
                insertString = insertString + "''" + "," //Ship to City Cd 28
                insertString = insertString + "'" + it.attribute26 + "'" + "," //Attr26 29
                insertString = insertString + "'" + it.attribute27 + "'" + "," //Attr27 30
                insertString = insertString + "''" + "," //Attr28 31
                insertString = insertString + "''" + "," //Attr29 32
                insertString = insertString + "''"//Attr30 33
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        // }  ) // stmt

        connection.disconnect()

    }

    void pullLPMOther() {

        def insertString;

        def connection = new URL(urlPX + "LPMOtherProductCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
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
        sql.execute("DELETE FROM XXSO_M_LPMOTHERPRODCHARACT")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertLPMOther(i,x)
        }


    }

    void insertLPMOther(int from, int to) {

        def insertString;

        def connection = new URL(urlPX + "LPMOtherProductCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_LPMOTHERPRODCHARACT VALUES ("
                insertString = insertString + "'" + it.sku + "'" + "," //CustomerId 1
                insertString = insertString + "'" + it.attribute5 + "'" + "," //PricingFamily
                insertString = insertString + "'" + it.attribute2 + "'" + "," //ProductGroup
                insertString = insertString + "'" + it.attribute3 + "'" + "," //SpecNumber
                insertString = insertString + "'" + it.attribute4?.replace("'", " ") + "'" + "," //SpecDescription
                insertString = insertString + "'" + it.attribute20 + "'" + "," //ProductLine
                insertString = insertString + "'" + it.attribute1 + "'" + "," //ItemNumber
                insertString = insertString + "'" + it.attribute22 + "'" + "," //ActiveFrom
                insertString = insertString + "'" + it.attribute7 + "'" + "," //LinerDescription 2
                insertString = insertString + "'" + it.attribute6 + "'" + "," //LinerBase 2
                insertString = insertString + "'" + it.attribute8 + "'" + "," //Release 2
                insertString = insertString + "'" + it.attribute17 + "'" + "," //MiscUpchargeCode
                insertString = insertString + "'" + it.attribute18 + "'" + "," //MiscUpchargeCode2
                insertString = insertString + "'" + it.attribute19 + "'" + "," //MiscUpchargeCode3
                insertString = insertString + "'" + it.attribute13 + "'" + "," //WidthFamily
                insertString = insertString + "'" + it.attribute12?.replace("'", " ") + "'" + "," //BestAvailableStockStatus
                insertString = insertString + "'" + it.attribute9 + "'" + "," //ManualFloorPrice
                insertString = insertString + "'" + it.attribute14 + "'" + "," //ProductStrategy
                insertString = insertString + "'" + it.attribute15?.replace("'", " ") + "'" + ","
                //PriceRestrictedReasonCode
                insertString = insertString + "'" + it.attribute16 + "'" + "," //Item Status Code
                insertString = insertString + "'" + it.attribute24 + "'" + "," //ReadyforPricing
                insertString = insertString + "'" + it.attribute25 + "'" + "," //AttributesFilled
                insertString = insertString + "'" + it.attribute26 + "'" + "," //FlagBlock
                insertString = insertString + "'" + it.attribute27 + "'" + "," //ItemUOM
                insertString = insertString + "'" + it.attribute28 + "'" + "," //ConversionFactor
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update Date
                insertString = insertString + "'" + it.attribute10?.replace("'", " ") + "'" + "," //ItemDescription
                insertString = insertString + "'" + it.attribute11 + "'" + "," //Attr. 11
                insertString = insertString + "'" + it.attribute21 + "'" + "," //Attr. 21
                insertString = insertString + "'" + it.attribute23 + "'" + "," //Attr. 23
                insertString = insertString + "'" + it.attribute29 + "'" + "," //FreightRate
                insertString = insertString + "'" + it.attribute30 + "'" //Attr. 30
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        //} ) //stmt

        connection.disconnect()

    }

    void pullLPMOtherSrc() {

        def insertString;

        def connection = new URL(urlPXSrc + "LPMOtherProductCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
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
        sql.execute("DELETE FROM XXSO_M_LPMOTHERPRODCHARACT_SRC")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertLPMOtherSrc(i,x)
        }


    }

    void insertLPMOtherSrc(int from, int to) {

        def insertString;

        def connection = new URL(urlPXSrc + "LPMOtherProductCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_LPMOTHERPRODCHARACT_SRC VALUES ("
                insertString = insertString + "'" + it.sku + "'" + "," //CustomerId 1
                insertString = insertString + "'" + (it.attribute5?:"") + "'" + "," //PricingFamily
                insertString = insertString + "'" + (it.attribute2?:"") + "'" + "," //ProductGroup
                insertString = insertString + "'" + it.attribute3 + "'" + "," //SpecNumber
                insertString = insertString + "'" + it.attribute4?.replace("'", " ") + "'" + "," //SpecDescription
                insertString = insertString + "'" + it.attribute20 + "'" + "," //ProductLine
                insertString = insertString + "'" + it.attribute1 + "'" + "," //ItemNumber
                insertString = insertString + "'" + it.attribute22 + "'" + "," //ActiveFrom
                insertString = insertString + "'" + (it.attribute7?:"") + "'" + "," //LinerDescription 2
                insertString = insertString + "'" + (it.attribute6?:"") + "'" + "," //LinerBase 2
                insertString = insertString + "'" + (it.attribute8?:"") + "'" + "," //Release 2
                insertString = insertString + "'" + (it.attribute17?:"") + "'" + "," //MiscUpchargeCode
                insertString = insertString + "'" + (it.attribute18?:"") + "'" + "," //MiscUpchargeCode2
                insertString = insertString + "'" + (it.attribute19?:"") + "'" + "," //MiscUpchargeCode3
                insertString = insertString + "'" + (it.attribute13?:"") + "'" + "," //WidthFamily
                insertString = insertString + "'" + (it.attribute12?.replace("'", " ")?:"") + "'" + "," //BestAvailableStockStatus
                insertString = insertString + "'" + (it.attribute9?:"") + "'" + "," //ManualFloorPrice
                insertString = insertString + "'" + (it.attribute14?:"") + "'" + "," //ProductStrategy
                insertString = insertString + "'" + (it.attribute15?.replace("'", " ")?:"") + "'" + "," //PriceRestrictedReasonCode
                insertString = insertString + "'" + (it.attribute16?:"") + "'" + "," //Item Status Code
                insertString = insertString + "'" + (it.attribute24?:"") + "'" + "," //ReadyforPricing
                insertString = insertString + "'" + (it.attribute25?:"") + "'" + "," //AttributesFilled
                insertString = insertString + "'" + (it.attribute26?:"") + "'" + "," //FlagBlock
                insertString = insertString + "'" + (it.attribute27?:"") + "'" + "," //ItemUOM
                insertString = insertString + "'" + (it.attribute28?:"") + "'" + "," //ConversionFactor
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update Date
                insertString = insertString + "'" + (it.attribute10?.replace("'", " ")?:"") + "'" + "," //ItemDescription
                insertString = insertString + "'" + (it.attribute11?:"") + "'" + "," //Attr. 11
                insertString = insertString + "'" + (it.attribute21?:"") + "'" + "," //Attr. 21
                insertString = insertString + "'" + (it.attribute23?:"") + "'" + "," //Attr. 23
                insertString = insertString + "'" + (it.attribute29?:"") + "'" + "," //FreightRate
                insertString = insertString + "'" + (it.attribute30?:"") + "'" //Attr. 30
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        // } ) //stmt

        connection.disconnect()

    }

    void pullLPMComponent() {

        def insertString;

        def connection = new URL(urlPX + "LPMComponentCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
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
        sql.execute("DELETE FROM XXSO_M_LPMCOMPONENTCHARACT")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertLPMComponent(i,x)
        }


    }

    void insertLPMComponent(int from, int to) {

        def insertString;

        def connection = new URL(urlPX + "LPMComponentCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_LPMCOMPONENTCHARACT VALUES ("
                insertString = insertString + "'" + it.sku + "'" + "," //Product_ID
                insertString = insertString + "'" + it.attribute26 + "'" + "," //PricingFamily
                insertString = insertString + "'" + it.attribute28 + "'" + "," //ProductGroup
                insertString = insertString + "'" + it.attribute30 + "'" + "," //SpecNumber
                insertString = insertString + "'" + it.attribute27?.replace("'"," ")?.replace("'"," ") + "'" + "," //ItemDescription
                insertString = insertString + "'" + it.attribute1 + "'" + "," //ItemNumber
                insertString = insertString + "'" + it.attribute2 + "'" + "," //ActiveFrom
                insertString = insertString + "'" + it.attribute6 + "'" + "," //Appearance
                insertString = insertString + "'" + it.attribute9 + "'" + "," //Caliper/ Weight
                insertString = insertString + "'" + it.attribute7 + "'" + "," //Coating
                insertString = insertString + "'" + it.attribute5 + "'" + "," //Composition
                insertString = insertString + "'" + it.attribute11 + "'" + "," //Other
                insertString = insertString + "'" + it.attribute3 + "'" + "," //Base
                insertString = insertString + "'" + it.attribute13 + "'" + "," //DataCapacity
                insertString = insertString + "'" + it.attribute12 + "'" + "," //MidPly
                insertString = insertString + "'" + it.attribute15 + "'" + "," //NFC
                insertString = insertString + "'" + it.attribute4 + "'" + "," //Pharma
                insertString = insertString + "'" + it.attribute8 + "'" + "," //PrintTech
                insertString = insertString + "'" + it.attribute10 + "'" + "," //TamperEvident
                insertString = insertString + "'" + it.attribute14 + "'" + "," //VisualIndicator
                insertString = insertString + "'" + it.attribute16 + "'" + "," //Weld
                insertString = insertString + "'" + it.attribute18 + "'" + "," //AdhesiveDescription 1
                insertString = insertString + "'" + it.attribute17 + "'" + "," //AdhesiveBase 1
                insertString = insertString + "'" + it.attribute19 + "'" + "," //CtWt1
                insertString = insertString + "'" + it.attribute29 + "'" + "," //PatternGum
                insertString = insertString + "'" + it.attribute21 + "'" + "," //LinerDescription 1
                insertString = insertString + "'" + it.attribute20 + "'" + "," //LinerBase 1
                insertString = insertString + "'" + it.attribute22 + "'" + "," //Release 1
                insertString = insertString + "'" + it.attribute25 + "'" + "," //AdhesiveDescription 2
                insertString = insertString + "'" + it.attribute24 + "'" + "," //AdhesiveBase 2
                insertString = insertString + "'" + it.attribute23 + "'" + "," //CtWt2
                insertString = insertString + "'" + it.lastUpdateDate + "'" //Last Update Date
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        // } ) //stmt

        connection.disconnect()

    }

    void pullLPMComponentSrc() {

        def insertString;

        def connection = new URL(urlPXSrc + "LPMComponentCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
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
        sql.execute("DELETE FROM XXSO_M_LPMCOMPONENTCHARACT_SRC")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertLPMComponentSrc(i,x)
        }


    }

    void insertLPMComponentSrc(int from, int to) {

        def insertString;

        def connection = new URL(urlPXSrc + "LPMComponentCharacteristics?isc_dataFormat=json").openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_LPMCOMPONENTCHARACT_SRC VALUES ("
                insertString = insertString + "'" + it.sku + "'" + "," //Product_ID
                insertString = insertString + "'" + (it.attribute26?:"") + "'" + "," //PricingFamily
                insertString = insertString + "'" + (it.attribute28?:"") + "'" + "," //ProductGroup
                insertString = insertString + "'" + it.attribute30 + "'" + "," //SpecNumber
                insertString = insertString + "'" + it.attribute27?.replace("'"," ")?.replace("'"," ") + "'" + "," //ItemDescription
                insertString = insertString + "'" + it.attribute1 + "'" + "," //ItemNumber
                insertString = insertString + "'" + it.attribute2 + "'" + "," //ActiveFrom
                insertString = insertString + "'" + (it.attribute6?:"") + "'" + "," //Appearance
                insertString = insertString + "'" + (it.attribute9?:"") + "'" + "," //Caliper/ Weight
                insertString = insertString + "'" + (it.attribute7?:"") + "'" + "," //Coating
                insertString = insertString + "'" + (it.attribute5?:"") + "'" + "," //Composition
                insertString = insertString + "'" + (it.attribute11?:"") + "'" + "," //Other
                insertString = insertString + "'" + (it.attribute3?:"") + "'" + "," //Base
                insertString = insertString + "'" + (it.attribute13?:"") + "'" + "," //DataCapacity
                insertString = insertString + "'" + (it.attribute12?:"") + "'" + "," //MidPly
                insertString = insertString + "'" + (it.attribute15?:"") + "'" + "," //NFC
                insertString = insertString + "'" + (it.attribute4?:"") + "'" + "," //Pharma
                insertString = insertString + "'" + (it.attribute8?:"") + "'" + "," //PrintTech
                insertString = insertString + "'" + (it.attribute10?:"") + "'" + "," //TamperEvident
                insertString = insertString + "'" + (it.attribute14?:"") + "'" + "," //VisualIndicator
                insertString = insertString + "'" + (it.attribute16?:"") + "'" + "," //Weld
                insertString = insertString + "'" + (it.attribute18?:"") + "'" + "," //AdhesiveDescription 1
                insertString = insertString + "'" + (it.attribute17?:"") + "'" + "," //AdhesiveBase 1
                insertString = insertString + "'" + (it.attribute19?:"") + "'" + "," //CtWt1
                insertString = insertString + "'" + (it.attribute29?:"") + "'" + "," //PatternGum
                insertString = insertString + "'" + (it.attribute21?:"") + "'" + "," //LinerDescription 1
                insertString = insertString + "'" + (it.attribute20?:"") + "'" + "," //LinerBase 1
                insertString = insertString + "'" + (it.attribute22?:"") + "'" + "," //Release 1
                insertString = insertString + "'" + (it.attribute25?:"") + "'" + "," //AdhesiveDescription 2
                insertString = insertString + "'" + (it.attribute24?:"") + "'" + "," //AdhesiveBase 2
                insertString = insertString + "'" + (it.attribute23?:"") + "'" + "," //CtWt2
                insertString = insertString + "'" + it.lastUpdateDate + "'" //Last Update Date
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        //} ) //stmt

        connection.disconnect()

    }

    void pullProducts() {

        def insertString;

        def connection = new URL(url + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
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
        sql.execute("DELETE FROM XXSO_M_PFXITEMMASTER")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertProducts(i,x)
        }

    }

    void insertProducts(int from, int to) {

        def insertString;

        def connection = new URL(url + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', login)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_PFXITEMMASTER VALUES ("
                insertString = insertString + "'" + it.sku?.replace("'"," ")?.replace("\""," ") + "'" + "," //Product_ID
                insertString = insertString + "'" + it.label?.replace("'"," ")?.replace("\""," ") + "'" + "," //SOLD_ITEM_DESC
                insertString = insertString + "'" + it.unitOfMeasure + "'" + "," //SOURCE_SYSTEM_CD
                insertString = insertString + "'" + it.currency + "'" + "," //SFDC_IDENTIFIER
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update
                insertString = insertString + "'" + it.formulaName + "'" + "," //Pricing logic
                insertString = insertString + "'" + it.attribute1 + "'" + "," //SOURCE_SUB_SYSTEM_CD
                insertString = insertString + "'" + it.attribute2 + "'" + "," //EXTRACT_ID
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
                insertString = insertString + "'" + it.attribute13?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_STOCK_TYPE_DESC
                insertString = insertString + "'" + it.attribute14 + "'" + "," //ITEM_STATUS_CD
                insertString = insertString + "'" + it.attribute15?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_STATUS_DESC
                insertString = insertString + "'" + it.attribute16 + "'" + "," //ITEM_GROUP_CD
                insertString = insertString + "'" + it.attribute17?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_GROUP_DESC
                insertString = insertString + "'" + it.attribute18?.replace("'"," ")?.replace("\""," ") + "'" + "," //ITEM_2_DESC
                insertString = insertString + "'" + it.attribute19 + "'" + "," //SUB_PROD_LINE_TEAM_CD
                insertString = insertString + "'" + it.attribute20?.replace("'"," ") + "'" + "," //SUB_PROD_LINE_TEAM_DESC
                insertString = insertString + "'" + it.attribute21 + "'" + "," //ITEM_BASE_UOM_CD
                insertString = insertString + "'" + it.attribute22 + "'" + "," //GRS_PROD_TECH_CD
                insertString = insertString + "'" + it.attribute23?.replace("'"," ")?.replace("\""," ") + "'" + "," //GRS_PROD_TECH_DESC
                insertString = insertString + "'" + it.attribute24 + "'" + "," //GRS_MAJOR_PROD_GROUP_CD
                insertString = insertString + "'" + it.attribute25?.replace("'"," ")?.replace("\""," ") + "'" + "," //GRS_MAJOR_PROD_GROUP_DESC
                insertString = insertString + "'" + it.attribute26 + "'" + "," //SOLD_ITEM_CD
                insertString = insertString + "'" + it.attribute27 + "'" + "," //Ready For Pricing
                insertString = insertString + "'" + it.attribute28 + "'" + "," //Pricing Sub-Group
                insertString = insertString + "'" + it.attribute29 + "'" + "," //Pattern Gum
                insertString = insertString + "'" + it.attribute30 + "'" //Attr. 30
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        //} ) //stmt

        connection.disconnect()

    }

    void pullProductsSrc() {

        def insertString;

        def connection = new URL(urlSrc + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection

        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
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
        sql.execute("DELETE FROM XXSO_M_PFXITEMMASTER_SRC")

        for ( int i = 0; i < totalRows ; i = i + rowLimit) {
            int x = i + rowLimit - 1
            this.insertProductsSrc(i,x)
        }


    }

    void insertProductsSrc(int from, int to) {

        def insertString;

        def connection = new URL(urlSrc + 'productmanager.fetchproducts?&isc_dataFormat=json').openConnection() as HttpURLConnection
        connection.setDoOutput(true)
        connection.setRequestMethod("POST")
        connection.setRequestProperty('Authorization', loginSrc)
        connection.setRequestProperty("Content-Type", "application/json")

        def httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))
        httpRequestBodyWriter.write("{ \"operationType\":\"fetch\", \"startRow\":${from}, \"endRow\":${to}  }")
        httpRequestBodyWriter.close()
        def jsonSlurper = new JsonSlurper()
        def api = jsonSlurper.parseText(connection.inputStream.text)

        //sql.withBatch ( { stmt ->

            api.response.data.each {

                insertString = "INSERT INTO XXSO_M_PFXITEMMASTER_SRC VALUES ("
                insertString = insertString + "'" + it.sku?.replace("'", " ")?.replace("\"", " ") + "'" + "," //Product_ID
                insertString = insertString + "'" + it.label?.replace("'", " ")?.replace("\"", " ") + "'" + "," //SOLD_ITEM_DESC
                insertString = insertString + "'" + it.unitOfMeasure + "'" + "," //SOURCE_SYSTEM_CD
                insertString = insertString + "'" + it.currency + "'" + "," //SFDC_IDENTIFIER
                insertString = insertString + "'" + it.lastUpdateDate + "'" + "," //Last Update
                insertString = insertString + "'" + it.formulaName + "'" + "," //Pricing logic
                insertString = insertString + "'" + it.attribute1 + "'" + "," //SOURCE_SUB_SYSTEM_CD
                insertString = insertString + "'" + it.attribute2 + "'" + "," //EXTRACT_ID
                insertString = insertString + "'" + it.attribute?.replace("'", " ")?.replace("\"", " ") + "'" + "," //SPEC_DESC
                insertString = insertString + "'" + it.attribute4?.replace("'", " ")?.replace("\"", " ") + "'" + "," //SPEC_CD
                insertString = insertString + "'" + it.attribute5 + "'" + "," //PROD_LINE_TEAM_CD
                insertString = insertString + "'" + it.attribute6 + "'" + "," //Pressure_Sensitive
                insertString = insertString + "'" + it.attribute7?.replace("'", " ")?.replace("\"", " ") + "'" + "," //PROD_LINE_TEAM_DESC
                insertString = insertString + "'" + it.attribute8 + "'" + "," //PROD_LINE_CD
                insertString = insertString + "'" + it.attribute9?.replace("'", " ")?.replace("\"", " ") + "'" + "," //PROD_LINE_DESC
                insertString = insertString + "'" + it.attribute10 + "'" + "," //PROD_GROUP_CD
                insertString = insertString + "'" + it.attribute11?.replace("'", " ")?.replace("\"", " ") + "'" + "," //PROD_GROUP_DESC
                insertString = insertString + "'" + it.attribute12 + "'" + "," //ITEM_STOCK_TYPE_CD
                insertString = insertString + "'" + it.attribute13?.replace("'", " ")?.replace("\"", " ") + "'" + "," //ITEM_STOCK_TYPE_DESC
                insertString = insertString + "'" + it.attribute14 + "'" + "," //ITEM_STATUS_CD
                insertString = insertString + "'" + it.attribute15?.replace("'", " ")?.replace("\"", " ") + "'" + "," //ITEM_STATUS_DESC
                insertString = insertString + "'" + it.attribute16 + "'" + "," //ITEM_GROUP_CD
                insertString = insertString + "'" + it.attribute17?.replace("'", " ")?.replace("\"", " ") + "'" + "," //ITEM_GROUP_DESC
                insertString = insertString + "'" + it.attribute18?.replace("'", " ")?.replace("\"", " ") + "'" + "," //ITEM_2_DESC
                insertString = insertString + "'" + it.attribute19 + "'" + "," //SUB_PROD_LINE_TEAM_CD
                insertString = insertString + "'" + it.attribute20?.replace("'", " ")?.replace("\"", " ") + "'" + "," //SUB_PROD_LINE_TEAM_DESC
                insertString = insertString + "'" + it.attribute21 + "'" + "," //ITEM_BASE_UOM_CD
                insertString = insertString + "'" + it.attribute22 + "'" + "," //GRS_PROD_TECH_CD
                insertString = insertString + "'" + it.attribute23?.replace("'", " ")?.replace("\"", " ") + "'" + "," //GRS_PROD_TECH_DESC
                insertString = insertString + "'" + it.attribute24 + "'" + "," //GRS_MAJOR_PROD_GROUP_CD
                insertString = insertString + "'" + it.attribute25?.replace("'", " ")?.replace("\"", " ") + "'" + "," //GRS_MAJOR_PROD_GROUP_DESC
                insertString = insertString + "'" + it.attribute26?.replace("'", " ")?.replace("\"", " ") + "'" + "," //SOLD_ITEM_CD
                insertString = insertString + "'" + it.attribute27 + "'" + "," //Ready For Pricing
                insertString = insertString + "'" + it.attribute28 + "'" + "," //Pricing Sub-Group
                insertString = insertString + "'" + it.attribute29 + "'" + "," //Pattern Gum
                insertString = insertString + "'" + it.attribute30 + "'" //Attr. 30
                insertString = insertString + ")"

                sql.execute(insertString)
                //stmt.addBatch(insertString)
            }
            //stmt.executeBatch()

        //} ) //stmt

        connection.disconnect()

    }

}

