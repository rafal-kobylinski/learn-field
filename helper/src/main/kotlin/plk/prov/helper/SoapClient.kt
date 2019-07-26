package plk.prov.helper

import com.gargoylesoftware.htmlunit.HttpMethod
import com.gargoylesoftware.htmlunit.Page
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.WebRequest
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.net.URL

@Service
class SoapClient {
    val url = "https://10.218.20.139/ProvisioningGateway/services/SPMLSubscriber10Service"
    val requestSettings = WebRequest(URL(url), HttpMethod.POST)
    val webClient = WebClient()

    init {
        requestSettings.setAdditionalHeader("Content-Type", "application/soap+xml;charset=UTF-8")
        requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate")
        requestSettings.setAdditionalHeader("SOAPAction", "urn:siemens:names:prov:gw:SPML:2:0/searchRequest")
        requestSettings.setAdditionalHeader("Connection", "Keep-Alive")
        requestSettings.setAdditionalHeader("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)")
        webClient.options.isUseInsecureSSL = true
    }

    fun execute(msisdn : String) : String {

        requestSettings.requestBody = "" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:spml=\"urn:siemens:names:prov:gw:SPML:2:0\" xmlns:subscriber=\"urn:siemens:names:prov:gw:SUBSCRIBER:1:0\" xsi:schemaLocation=\"urn:siemens:names:prov:gw:SUBSCRIBER:1:0 subscriber-1.0.xsd\">\n" +
                "               <soapenv:Header>\n" +
                "                              <ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"/>\n" +
                "               </soapenv:Header>\n" +
                "               <soapenv:Body Id=\"Body\">\n" +
                "                              <spml:searchRequest language=\"en_us\" xmlns:spml=\"urn:siemens:names:prov:gw:SPML:2:0\" xmlns:subscriber=\"urn:siemens:names:prov:gw:SUBSCRIBER:1:0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "                                            <version>SUBSCRIBER_v10</version>\n" +
                "                                            <base>\n" +
                "                                                           <objectclass>Subscriber</objectclass>\n" +
                "                                                           <alias name=\"msisdn\" value=\"48${msisdn}\" />\n" +
                "                                            </base>\n" +
                "                              </spml:searchRequest>\n" +
                "               </soapenv:Body>\n" +
                "</soapenv:Envelope>"

        val redirectPage = webClient.getPage<Page>(requestSettings)

        return redirectPage.webResponse.contentAsString
    }
}