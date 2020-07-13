import groovy.time.*

def date
def start
def end
def builder = new fiscalCalendarBuilder()

start = new Date();
println "${new Date().toString()} - Generating Fiscal Calendar File";
builder.createFiscalCalendarFile()

end = new Date();

TimeDuration duration = TimeCategory.minus(end, start)

println "Total Duration: ${duration}"