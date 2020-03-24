package com.backend.v1.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/properties/config.properties")
public class PropertiesConfig{
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
          return new PropertySourcesPlaceholderConfigurer();
    }

}
