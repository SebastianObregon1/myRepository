def uniqueName = "R-3736"
def agreements = api.find("RBA", 0,1,"-lastUpdateDate",Filter.equal("uniqueName",uniqueName))

api.trace("Rebates",null,agreements)

for (agreement in agreements) {
    api.trace("Rebate","", agreement)
}

agreements = api.find("RBA", 0,1,"-lastUpdateDate",["inputsJson","outputsJson"], Filter.equal("uniqueName",uniqueName))

if (agreements) {
        inputs = Library.stringToList(agreements[0].inputsJson)
        api.trace("Inputs",null,api.jsonEncode(inputs))
        outputs = Library.stringToList(agreements[0].outputsJson)
        api.trace("Outputs",null,api.jsonEncode(outputs))
}

