package plk.prov.helper

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import plk.prov.helper.persistance.S2kService

@SpringBootApplication
class HelperApplication(val s2KService: S2kService, val soapClient: SoapClient) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(HelperApplication::class.java)

    override fun run(vararg args: String?) {
        log.info("run")
		//val test = s2KService.getAccount("665265620")
		//log.info("wynik: " + test)
        val test = soapClient.execute("665059691")
        log.info(test)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(HelperApplication::class.java, *args)
}
