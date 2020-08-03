
def contractName = out.ContractNumber
def contracts = api.find("CT", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",contractName))

api.trace("Contracts",null,contracts)

for (contract in contracts) {
    api.trace("Contract all fields","", contract)
}

contracts = api.find("CT", 0,1,"-lastUpdateDate",["uniqueName","inputsJson","outputsJson"], Filter.equal("uniqueName",contractName))


for (contract in contracts) {
  api.trace("Contract input and output","", contract)
}

if (contracts) {
        inputs = Library.stringToList(contracts[0].inputsJson)
        api.trace("Contract Inputs",null,api.jsonEncode(inputs))
        outputs = Library.stringToList(contracts[0].outputsJson)
        api.trace("Contract Outputs",null,api.jsonEncode(outputs))
}


