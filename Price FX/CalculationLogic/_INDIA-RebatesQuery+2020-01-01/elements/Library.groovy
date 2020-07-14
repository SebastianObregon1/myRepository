List stringToList(String json){
  if(!json)
    return []
  else if(json.startsWith("{"))
    return api.jsonDecode(json).values() as List
  else if(json.startsWith("["))
    return api.jsonDecodeList(json)
  else
    api.throwException("Json not in form of Map or List")
}
