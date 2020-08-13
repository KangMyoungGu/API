package com.backend.v1.adapter.impl;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public boolean checkTokenExpired(SessionDomain sessionDomain) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		try {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strExpDate = dateformat.format(sessionDomain.getExpiredDate());
			Date expDate = dateformat.parse(strExpDate);
			Date nowDate = dateformat.parse(dateformat.format(new Date().getTime()));
			
			int compare = expDate.compareTo(nowDate);

			if(compare < 0 ) {	// 토큰 만료됨
				return true;
			} else {
				return false;
			}
					
		} catch(ParseException e) {
			return false;
		}
	}
}
