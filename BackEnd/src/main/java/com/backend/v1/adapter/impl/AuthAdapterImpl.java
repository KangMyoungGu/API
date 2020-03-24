package com.backend.v1.adapter.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.v1.ApiHeader;
import com.backend.v1.RtCode;
import com.backend.v1.adapter.AuthAdapter;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.domain.account.SessionDomain;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class AuthAdapterImpl implements AuthAdapter{
	@Autowired TokenUtil tokenUtil;

	@Autowired RedisUtil redisUtil;
	public boolean checkAuth(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		// get SessionDomain by Token
		SessionDomain sessionDomain = tokenUtil.parseToken(token);
		
		// Token Falsification
		if(!token.equals(redisUtil.getTokenByRedisData(sessionDomain.getUserId()))) {
			return false;
		}

		// not found userId by sessionDomain
		if(sessionDomain.getUserId()== null || sessionDomain.getUserId().contentEquals("")) {
			return false;
		}
		
		return true;
	}
}
