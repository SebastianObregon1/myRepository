import groovy.time.*

def date
def start
def end
def app = new dataBuilder()

start = new Date();

app.setup("ad-na2")
//app.setup("ad-na-qa2")

app.openDBConnection()

println "${new Date().toString()} - Pulling Quotes from Price FX";
app.pullQuotes()

println "${new Date().toString()} - Pulling Products from Price FX";
//app.pullProducts()

println "${new Date().toString()} - Pulling Quotes from EBS";
app.pullQuotesFromEBS()


app.closeDBConnection()

end = new Date();

TimeDuration duration = TimeCategory.minus(end, start)

println "Total Duration: ${duration}"