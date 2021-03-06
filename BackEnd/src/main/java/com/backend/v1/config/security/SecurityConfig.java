package com.backend.v1.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) {
      //실제 인증을 진행할 Provider 
    }
	    
    @Override
    public void configure(WebSecurity web) {
	  //이미지,자바스크립트,css 디렉토리 보안 설정 
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
}
