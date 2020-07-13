import groovy.sql.Sql

class GroovyApp {

    void hello () {
            println("Hello, World");

            println("----------------------");

            ["Rod","Carlos","Chris"].findAll{ it.size() < 4}.each{println it}

            println("----------------------");

            def list = [1,2];
            def map = [cars: 2, boats: 3];

            println list.getClass()
            println map.getClass()

            map.cars = 7
            map.boats = 8
            map.planes = 1
            println map.cars
            println map.boats
            println map.planes

            println("----------------------");

            ["Java","Groovy","Scala"].each { println it }

            println("----------------------");

            5.times { println "Hola"}

            println("----------------------");

            def os = 'Linux'
            def cores = 2
            println("Cores: $cores, OS: $os, Time: ${new Date()}")

            println("----------------------");

            def list3 = ['foo','bar']
            def newList = []
            list3.collect( newList ) {
                    it.toUpperCase()
            }
            println newList

            println("----------------------");

            def closr = { x -> x - 1}
            println( closr(8))

            println("----------------------");

            def str = "test"
            str.metaClass.upper = { -> toUpperCase() }

            println ( str.upper() )

            println("----------------------");
            // Elvis Operator

            def str1 = null

            //String name = str1 == "Bob" ? "Yes" : "No"
            String name = str1 ?: "Null"

            println ( name )

            println("----------------------");
            println("--- Safe Deference");

            def str2 = null
            def person = [names: "Sebastian", lastName: "Obregon"]

            person = null
            String name2 = "zero"

            name2 = person?.lastName // Si saco el ? devuelve NullPointerException

            println ( name2 )

        println("----------------------");
        println("--- Operador *");

        def cars = [
                    new car(make: 'Peugeot', model: '508'),
                    new car(make:'Renault', model: 'Clio')]

            def makes = cars*.model

            println (makes.getClass())
            println ( makes )


            println("----------------------");
            println("--- Rest API");

            def connection = new URL( "https://ad.pricefx.eu/pricefx/ad-na-qa2/fetch/C").openConnection() as HttpURLConnection
            //def connection = new URL( "https://147.135.10.193/pricefx/ad-na-qa2/fetch/C").openConnection() as HttpURLConnection
            //def connection = new URL( "https://jsonplaceholder.typicode.com/users").openConnection() as HttpURLConnection
            connection.setRequestProperty('Authorization','BASIC YWQtbmEtcWEyL3NlYmFzdGlhbi5vYnJlZ29uMUBhdmVyeWRlbm5pc29uLmNvbS5zaXQ6b2JyZWdvbjE=')

            connection.setRequestProperty('Body', '{ "operationType":"fetch", "startRow":0, "endRow":10, "data":{ "name":"LPMOtherProductCharacteristics" } }')

            println connection.responseCode
            println connection.inputStream.text

        println("----------------------");
        println("--- SQL");


// Oracle DB Settings

        //DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

        def dbSchema = "Local"
        def dbServer = "Localhost"
        def dbUser = "sobregon"
        def dbPassword = "sobregon1"
        def dbDriver = "oracle.jdbc.driver.OracleDriver"
        //def dbUrl = 'jdbc:oracle:thin:@' + dbServer + ':' + dbSchema
        def dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"
        def sql = Sql.newInstance( dbUrl, dbUser, dbPassword, dbDriver )

// Read data
        def row = sql.firstRow("SELECT 1 FROM dual")
        println (row)



    }
}
