package com.backend.v1.config.database;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.backend.v1.common.util.PropertiesUtil;


@Configuration
@EnableAutoConfiguration
public class DatabaseConfig {

	@Autowired PropertiesUtil propertiesUtil;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(propertiesUtil.getProperty("MARIA.DRIVER.CLASS.NAME"));
		dataSource.setUrl(propertiesUtil.getProperty("MARIA.URL"));
		dataSource.setUsername(propertiesUtil.getProperty("MARIA.USER.NAME"));
		dataSource.setPassword(propertiesUtil.getProperty("MARIA.USER.PASSWORD"));

		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}
	
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
