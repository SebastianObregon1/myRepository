
def contractName = out.ContractNumber
def contracts = api.find("CT", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",contractName))

for (contract in contracts) {

  api.trace("Contract","", contract)
    
  for (li in contract.lineItems) {
        if (li.folder) {      
          api.trace("exit")
          continue
        }

    api.trace("Contract Line Item","",li)
    
    def liId = li.typedId.split("\\.")[0]
    def lineItems = api.find("CTLI", 0, 1,null, ["inputsJson","outputsJson"], Filter.equal("id", liId))   
    
    if (lineItems) {
        outputsList = Library.stringToList(lineItems[0].outputsJson)
        api.trace("Line Outputs",null,outputsList)
        inputsList = Library.stringToList(lineItems[0].inputsJson)
        api.trace("Line Inputs",null,inputsList)
    }
     
  }
}
