package com.backend.v1.config.webmvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.backend.v1.ApiHeader;
import com.backend.v1.common.token.interceptor.JwtInterceptor;
import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.PropertiesUtil;
import com.backend.v1.filter.CustomFilter;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired PropertiesUtil propertiesUtil;
	
	@Autowired JwtInterceptor jwtInterceptor;
	
    private static final String[] EXCLUDE_PATHS = {
            "/v1/api/user/login",
            "/v1/api/user/logout",
            "/v1/api/user/modify",
            "/v1/api/product/list/**",
            "/v1/api/product/info/**",
            "/img/**",
            "/v1/api/item/**/info/**",
            "/v1/api/test/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/webjars/springfox-swagger-ui/**",
            "/swagger/**",
            "/error"

    };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");

		String[] arr = propertiesUtil.getArrayProperty("IMAGE.TYPE.FOLDER", String[].class);
		 List<String> imageFolders = Arrays.asList(arr);
		for(String imageFolder : imageFolders) {
		 	
		registry.addResourceHandler("/img/" + imageFolder + "/**")
			.addResourceLocations("file://" + PropertiesUtil.getProperty("IMAGE.DEFAULT.FOLDER") + imageFolder + "/")
			.setCachePeriod(3600)
			.resourceChain(true)
			.addResolver(new PathResourceResolver());
		}
	}

	@Bean
    public FilterRegistrationBean filterRegistration() {
    	FilterRegistrationBean registrationBean = new FilterRegistrationBean(); 
    	registrationBean.setFilter(new CustomFilter());
    	registrationBean.addUrlPatterns("/*");
    	registrationBean.setName("CustomFilter");
    	return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
						.addPathPatterns("/**")
						.excludePathPatterns(EXCLUDE_PATHS);
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/*")
                .allowedOrigins("http://localhost:3000")
                .exposedHeaders(ApiHeader.TOKEN);
    }
}
