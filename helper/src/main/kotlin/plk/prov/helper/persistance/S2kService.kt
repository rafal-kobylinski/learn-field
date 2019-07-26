package plk.prov.helper.persistance

import org.springframework.stereotype.Component

@Component
class S2kService(val s2KDao: S2kDao) {

    fun getAccount(msisdn: String) = s2KDao.getByMsisdn(msisdn).toString()
}