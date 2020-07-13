
def contractName = "C-9459"
//def contracts = api.find("CT", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",contractName))

def contracts = api.find("CT", 0,1,"-lastUpdateDate",["inputsJson","outputsJson"], Filter.equal("uniqueName",contractName))

if (contracts) {
        outputs = Library.stringToList(contracts[0].outputsJson)
        api.trace("outputs ------>",null,api.jsonEncode(outputs))
        inputs = Library.stringToList(contracts[0].inputsJson)
        api.trace("inputs ------>",null,api.jsonEncode(inputs))
      }

api.trace("Contracts","", contracts)

for (contract in contracts) {

  api.trace("Contract","", contract)
  

}

