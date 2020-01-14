package com.beatshadow.aotmikosexamples.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 15:24
 */
@Configuration
@MapperScan(basePackages = {"com.beatshadow.aotmikosexamples.mapper.log"}, sqlSessionFactoryRef = "logsSqlSessionFactory")
public class LogsDataSourceConfiguration {

    public static final String MAPPER_XML_LOCATION = "classpath:mapperxml/log/*.xml";

    final DataSource logsDataSource;

    public LogsDataSourceConfiguration(@Qualifier("logsDataSource") DataSource logsDataSource) {
        this.logsDataSource = logsDataSource;
    }

    @Bean
    public SqlSessionTemplate logsSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(logsSqlSessionFactory());
    }

    @Bean
    public SqlSessionFactory logsSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(logsDataSource);
        //指定XML文件路径
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return factoryBean.getObject();
    }
}
