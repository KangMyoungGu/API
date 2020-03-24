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
	private static final String CLAIMS_KEY = "loginId";
	@Autowired
	private PropertiesUtil propertiesUtil;
	
	public SessionDomain parseToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
	Claims claims = Jwts.parser()
					.setSigningKey(propertiesUtil.getProperty("TOKEN_SECRET_KEY").getBytes("UTF-8"))
					.parseClaimsJws(token)
					.getBody();
	
	Map<String, String> map = (Map<String, String>) claims.get(claims.getSubject());

	SessionDomain session = new SessionDomain();
	try {
		session.setUserId(map.get(CLAIMS_KEY));
	} catch (Exception e) {
		throw new UnsupportedJwtException("Wrong format claim message", e);
	}

	return session;
	}
}
