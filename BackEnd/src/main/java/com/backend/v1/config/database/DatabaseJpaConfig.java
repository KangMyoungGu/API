package com.backend.v1.config.database;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.backend.v1.common.util.PropertiesUtil;

@Configuration
@EnableAutoConfiguration
public class DatabaseJpaConfig {
	
	@Autowired PropertiesUtil propertiesUtil;
	
	@Bean(name="jpaDataSource", destroyMethod="close")
	public DataSource jpaDataSource() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(propertiesUtil.getProperty("MARIA_DRIVER_CLASS_NAME"));
		dataSource.setUrl(propertiesUtil.getProperty("MARIA_URL"));
		dataSource.setUsername(propertiesUtil.getProperty("MARIA_USER_NAME"));
		dataSource.setPassword(propertiesUtil.getProperty("MARIA_USER_PASSWORD"));

		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(jpaDataSource());
		em.setPackagesToScan(new String[] {"com.backend.v1.data.entity.product"});
											
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}
	
	@Bean(name="jpaTransactionManager")
	public JpaTransactionManager jpaTransactionManager() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		
		return new JpaTransactionManager();
	}
	
	@Bean(name="exceptionTranslation")
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.id.new_generator_mappings", "true");
		return properties;
	}
}
