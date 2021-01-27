package com.backend.v1.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.v1.ApiHeader;
import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.domain.account.RequestUser;
import com.backend.v1.data.domain.account.SessionDomain;


@Component
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

	private String tokenHeader = "X-BACKEND-TOKEN";
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader(tokenHeader);
		if(token != null) {
			
			SessionDomain sessionDomain = new TokenUtil().parseToken(request.getHeader(ApiHeader.TOKEN));
			RequestUser user = new RequestUser(sessionDomain);
			
			UsernamePasswordAuthenticationToken auth = 
	                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}

}