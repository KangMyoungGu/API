package com.backend.v1.config.database;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.backend.v1.common.util.PropertiesUtil;


@Configuration
public class DatabaseSecondConfig {

	@Autowired PropertiesUtil propertiesUtil;
	@Autowired ApplicationContext applicationContext;

	@Bean(name="secondDataSource", destroyMethod="close")
	public DataSource secondDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(propertiesUtil.getProperty("MARIA_DRIVER_CLASS_NAME"));
		dataSource.setUrl(propertiesUtil.getProperty("MARIA_URL"));
		dataSource.setUsername(propertiesUtil.getProperty("MARIA_USER_NAME"));
		dataSource.setPassword(propertiesUtil.getProperty("MARIA_USER_PASSWORD"));

		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}

	@Primary
	@Bean(name="secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/sql/*.xml"));

        return factoryBean.getObject();
    }

	@Primary
    @Bean(name="secondSqlSession")
    public SqlSessionTemplate secondSqlSession(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

	@Primary
    @Bean(name="secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager(@Autowired @Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
