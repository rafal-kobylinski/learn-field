package plk.prov.helper.persistance

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class S2kDao(@Qualifier("s2kJdbcTemplate") private val s2kJdbcTemplate: JdbcTemplate) {

    fun getByMsisdn(msisdn: String): S2k? {
        return s2kJdbcTemplate.query(
                "select S.CUSTOMER_ACCOUNT, PN.SYSTEM_ID\n" +
                        "from SERVICES S, PHONE_NUMBERS PN\n" +
                        "where\n" +
                        "S.NDC = convert(numeric(3), substring('$msisdn', 1, 3))\n" +
                        "and S.HLR = convert(numeric(2), substring('$msisdn', 4, 2))\n" +
                        "and S.REGION = convert(numeric(2), substring('$msisdn', 6, 2))\n" +
                        "and S.SN = convert(numeric(2), substring('$msisdn', 8, 2)) * 10000\n" +
                        "and S.NDC = PN.NDC\n" +
                        "and S.HLR = PN.HLR\n" +
                        "and S.REGION = PN.REGION\n" +
                        "and S.SN = PN.SN\n" +
                        "and EFFECTIVE_DATE = (\n" +
                        "\tselect max(EFFECTIVE_DATE) \n" +
                        "\tfrom SERVICES S2\n" +
                        "     where \n" +
                        "\t\tS2.CUSTOMER_ACCOUNT = S.CUSTOMER_ACCOUNT\n" +
                        "\t\tand S2.CUSTOMER_SUB_ACCOUNT = S.CUSTOMER_SUB_ACCOUNT\n" +
                        "\t\tand S2.SERVICE_SEQ_NUM = S.SERVICE_SEQ_NUM)"
        ) { rs, _ ->
                S2k(
                        rs.getString("CUSTOMER_ACCOUNT"),
                        rs.getString("SYSTEM_ID")
                )
        }.firstOrNull()
    }
}