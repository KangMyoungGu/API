package com.backend.v1.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

public class CustomFilter extends RequestContextFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
	throws ServletException, IOException
	{
		try {
			CustomRequestWrapper customRequestWrapper = new CustomRequestWrapper(request);
			customRequestWrapper.setAttribute("requestBody", customRequestWrapper.getRequestBody());
			filterChain.doFilter(customRequestWrapper, response);
		} catch (Exception e) {
			filterChain.doFilter(request, response);
		}
	}

}
