package com.backend.v1.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.backend.v1.common.util.PropertiesUtil;
//import com.sun.tools.javac.util.StringUtils;	

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

		@Autowired
		private PropertiesUtil propertiesUtil;
		
		
		@Bean(name = "jedisTokenPool", destroyMethod = "close")
		public JedisPool jedisTokenPool() {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(10);
			config.setMinIdle(10);
			config.setMaxTotal(20);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			JedisPool pool;

			pool = new JedisPool(config, propertiesUtil.getProperty("REDIS.IP"), Integer.parseInt(propertiesUtil.getProperty("REDIS.PORT")), 60, null);


			return pool;
		}
		
		@SuppressWarnings("deprecation")
		@Bean
		public JedisConnectionFactory connectionFactory() {				
			JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
			jedisConnectionFactory.setHostName(propertiesUtil.getProperty("REDIS.IP"));
			jedisConnectionFactory.setPort(Integer.parseInt(propertiesUtil.getProperty("REDIS.PORT")));
			jedisConnectionFactory.setUsePool(true);
			jedisConnectionFactory.afterPropertiesSet();
			return jedisConnectionFactory;
		}
		
		@Bean
		public RedisTemplate<String, Object> redisTemplate() {
			RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			redisTemplate.setValueSerializer(new StringRedisSerializer());
			redisTemplate.setConnectionFactory(connectionFactory());
			return redisTemplate;
		}
		
	}

