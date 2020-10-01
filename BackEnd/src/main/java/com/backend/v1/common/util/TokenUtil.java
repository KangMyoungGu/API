package com.backend.v1.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.v1.data.domain.account.SessionDomain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenUtil {
	private static final String USERID_KEY = "userId";
	private static final String EXPIRED_KEY = "expiredDate";
	private static final String USERNO_KEY = "userNo";
	private static final String ROLE_KEY = "role";

	@Autowired
	private PropertiesUtil propertiesUtil;
	
	public SessionDomain parseToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		SessionDomain sessionDomain = null;
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(propertiesUtil.getProperty("TOKEN_SECRET_KEY").getBytes("UTF-8"))
					.parseClaimsJws(token)
					.getBody();
			sessionDomain = new SessionDomain();
			sessionDomain.setUserId(claims.get(USERID_KEY, String.class));
			sessionDomain.setUserNo(claims.get(USERNO_KEY, String.class));
			sessionDomain.setRole(claims.get(ROLE_KEY, String.class));
			sessionDomain.setExpiredDate(claims.get(EXPIRED_KEY, Long.class));
			
			return sessionDomain;
		} catch (Exception e) {
			return sessionDomain;
		}
	}
}
