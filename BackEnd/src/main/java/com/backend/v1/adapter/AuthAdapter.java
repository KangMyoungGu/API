package com.backend.v1.adapter;

import java.io.UnsupportedEncodingException;

import com.backend.v1.data.domain.account.SessionDomain;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public interface AuthAdapter {

	boolean checkTokenExpired(SessionDomain sessionDomain) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException;
}
