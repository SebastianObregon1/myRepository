def contractNumber = out.ContractNumber

def currentCTNum = contractNumber.split("-")[1]

def workflowInfoObj = api.findWorkflowInfo("CT", currentCTNum)

api.trace("WorkflowObj","",workflowInfoObj)