
def uniqueName = "R-3726"
def agreements = api.find("RBA", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",uniqueName))

for (agreement in agreements) {

  api.trace("Agreement","", agreement)
    
  for (li in agreement.lineItems) {
        if (li.folder) {      
          api.trace("exit")
          continue
        }

    api.trace("Agreement Line Item","",li)
    
    def liId = li.typedId.split("\\.")[0]
    def lineItems = api.find("RBALI", 0, 1,null, ["inputsJson","outputsJson"], Filter.equal("id", liId))   
    
    if (lineItems) {
        outputsList = Library.stringToList(lineItems[0].outputsJson)
        api.trace("Line Outputs",null,api.jsonEncode(outputsList))
        inputsList = Library.stringToList(lineItems[0].inputsJson)
        api.trace("Line Inputs",null,api.jsonEncode(inputsList))
      }
     
    /*
     for (input in inputsList) {
      	api.trace("input: " + input.name, input.value) 
     }
    
     for (output in outputsList) {
      	if ( output.resultType == "SIMPLE" && output.resultName == "NetPrice" ) {       
      		api.trace("output name: " + output.resultName, "output label:" + output.resultLabel, output.result)      
     }
	
    }
	*/
  }
}
