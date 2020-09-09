package com.backend.v1.common.token.service;


import com.backend.v1.ApiHeader;
import com.backend.v1.Exception.UnauthorizedException;
import com.backend.v1.common.util.PropertiesUtil;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtServiceImpl implements JwtService {

	private final Logger log = Logger.getLogger(JwtService.class);

	@Override
	public <T> String createToken(String key, T data, String subject){
		Map<String, Object> claims = new HashMap<String, Object>();
		Long expiredTime = 1000*3600*24*Long.parseLong(PropertiesUtil.getProperty("TOKEN_EXPIRED_LIMIT"));
		
		Date now = new Date();
		now.setTime(now.getTime() + expiredTime);
		claims.put("userId", key);
		claims.put("expiredDate", now.getTime());
		
		String jwt = Jwts.builder()
						 .setHeaderParam("typ", "JWT")
						 .setHeaderParam("regDate", System.currentTimeMillis())
						 .setSubject(key)
						 .setClaims(claims)
						 .signWith(SignatureAlgorithm.HS256, this.generateKey())
						 .compact();
		return jwt;
	}	

	private byte[] generateKey(){
		byte[] key = null;
		try {
			System.out.println(PropertiesUtil.getProperty("TOKEN_SECRET_KEY"));
			key = PropertiesUtil.getProperty("TOKEN_SECRET_KEY").getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			if(log.isInfoEnabled()){
				e.printStackTrace();
			}else{
				log.error("Making JWT Key Error ::: {}", e);
			}
		}
		
		return key;
	}
	
	@Override
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader(ApiHeader.TOKEN);
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(PropertiesUtil.getProperty("TOKEN_SECRET_KEY").getBytes("UTF-8"))
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
		return value;
	}
	
	
	@Override
	public boolean isUsable(String jwt) {
		System.out.println("jwt ::: " + jwt);
		try{
			Jws<Claims> claims = Jwts.parser()
					  .setSigningKey(this.generateKey())
					  .parseClaimsJws(jwt);
			return true;
			
		}catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

}
