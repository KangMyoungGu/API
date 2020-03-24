package com.backend.v1.common.token.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.backend.v1.ApiHeader;
import com.backend.v1.Exception.UnauthorizedException;
import com.backend.v1.common.token.service.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor{

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 

		if(request.getHeader(ApiHeader.TOKEN) != null 
				&& "".equals(request.getHeader(ApiHeader.TOKEN))
				&& jwtService.isUsable(request.getHeader(ApiHeader.TOKEN))
				
		 )   { return true; }
		else { throw new UnauthorizedException(); }

	}
}
