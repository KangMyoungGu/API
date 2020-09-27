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
public class DatabaseConfig {

	@Autowired PropertiesUtil propertiesUtil;
	@Autowired ApplicationContext applicationContext;

	@Primary
	@Bean(name="dataSource", destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(PropertiesUtil.getProperty("MARIA_DRIVER_CLASS_NAME"));
		dataSource.setUrl(PropertiesUtil.getProperty("MARIA_URL"));
		dataSource.setUsername(PropertiesUtil.getProperty("MARIA_USER_NAME"));
		dataSource.setPassword(PropertiesUtil.getProperty("MARIA_USER_PASSWORD"));

		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}

	@Primary
	@Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/sql/*.xml"));

        return factoryBean.getObject();
    }

	@Primary
    @Bean(name="sqlSession")
    public SqlSessionTemplate sqlSession(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

	@Primary
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
