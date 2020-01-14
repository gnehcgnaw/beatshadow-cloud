package com.beatshadow.aotmikosexamples.configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 15:13
 */
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {
    /**
     * atomikos_examples_logs数据库配置前缀
     */
    public final static String ATOMIKOS_EXAMPLES_LOGS = "spring.jta.atomikos.datasource.atomikos-examples-logs" ;
    /**
     * atomikos_examples_orders数据库配置前缀
     */
    public final static String ATOMIKOS_EXAMPLES_ORDERS = "spring.jta.atomikos.datasource.atomikos-examples-orders" ;

    @Bean(name = "logsDataSource")
    @ConfigurationProperties(prefix = ATOMIKOS_EXAMPLES_LOGS)
    public DataSource logsDataSource(){
        // org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
        return  new AtomikosDataSourceBean();

    }

    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = ATOMIKOS_EXAMPLES_ORDERS)
    public DataSource ordersDataSource(){
        return   new AtomikosDataSourceBean();
    }

}
