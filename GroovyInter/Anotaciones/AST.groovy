@Singleton
class ApiSystem {
  String emailerUrl = "http://emailerv2.modulusuno.com/"
 
  def getApiUrlRequest(metodo,params=[:]){
    "${emailerUrl}${metodo}?&${mapAsUrlParameters(params)}"
  }
 
  private String mapAsUrlParameters(Map params){
    params.collect{ k,v -> "${k}=${v}" }.join('&')
  }
}

@groovy.transform.Canonical
class Email {
  String id
  Date dateCreated
  Long version
  String subject
  String content
 
  static createWithParams(params){
    new Email(
      id:params.'_id',
      dateCreated:new Date().parse(params.'dateCreated'),
      version:params.'version',
      subject:params.'subject',
      content:params.'content'
    )
  }
}

import groovy.json.JsonSlurper
 
class BuscadorDeCervecerias {
  static metodoApi = "search/beer"
 
  static findByPais(String pais){
    def cerveceras = []
    def jsonSlurper = new JsonSlurper()
    def httpConnection = new URL(ApiSystem.instance.getApiUrlRequest(metodoApi,[q:pais]))
    def queryResult = jsonSlurper.parseText(httpConnection.text)
    cerveceras = queryResult.response.breweries.items.collect { c -> Cerveceria.createWithParams(c.brewery) }
    cerveceras
  }
}