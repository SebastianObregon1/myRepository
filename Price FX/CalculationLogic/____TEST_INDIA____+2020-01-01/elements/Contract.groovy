
def contractName = "C-9390"
def contracts = api.find("CT", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",contractName))

api.trace("Contracts",null,contracts)

for (contract in contracts) {
    api.trace("Contract","", contract)
}

contracts = api.find("CT", 0,1,"-lastUpdateDate",["inputsJson","outputsJson"], Filter.equal("uniqueName",contractName))

if (contracts) {
        inputs = Library.stringToList(contracts[0].inputsJson)
        api.trace("Inputs",null,api.jsonEncode(inputs))
        outputs = Library.stringToList(contracts[0].outputsJson)
        api.trace("Outputs",null,api.jsonEncode(outputs))
}

for (contract in contracts) {

  api.trace("Contract","", contract)
  

}

