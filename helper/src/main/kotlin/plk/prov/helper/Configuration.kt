package plk.prov.helper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
class Configuration {

    @Bean("s2kDataSource")
    //@ConfigurationProperties(prefix = "primary.datasource.s2k")
    //fun s2kDataSource() = DataSourceBuilder.create().build()
    fun s2kDataSource() : DataSource {
        val datasource = DriverManagerDataSource()
        datasource.setDriverClassName("com.sybase.jdbc4.jdbc.SybDriver")
        datasource.url = "jdbc:sybase:Tds:specsysdb:4210/DEV_01"
        datasource.username = ""
        datasource.password = ""

        return datasource
    }

    @Bean("s2kJdbcTemplate")
    @Autowired
    fun s2kJdbcTemplate(@Qualifier("s2kDataSource") s2kDataSource: DataSource)= JdbcTemplate(s2kDataSource)
}