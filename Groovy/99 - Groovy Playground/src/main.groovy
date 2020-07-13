
//app = new GroovyApp();
//app.hello();

def date

app = new pfxApiCaller();
app.openDBConnection();

//app.testAPI();

println "${new Date().toString()} - Pulling Customers";
app.pullCustomers();

println "${new Date().toString()} - Pulling Customers SRC";
app.pullCustomersSrc();

println "${new Date().toString()} - Pulling LPM Other";
app.pullLPMOther();

println "${new Date().toString()} - Pulling LPM Other SRC";
app.pullLPMOtherSrc();

println "${new Date().toString()} - Pull Products";
app.pullProducts();

println "${new Date().toString()} - Pull Products SRC";
app.pullProductsSrc();

println "${new Date().toString()} - Pull LPM Component";
app.pullLPMComponent();

println "${new Date().toString()} - Pull LPM Component SRC";
app.pullLPMComponentSrc();

app.closeDBConnection();

println "${new Date().toString()} - Process Finished";


