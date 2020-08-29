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

import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.data.domain.account.SessionDomain;


@Component
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

	@Value("${TOKEN_SECRET_KEY}")
	private String tokenHeader;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader(tokenHeader);
		if(token != null) {
			
			Map<String, Object> userMap = jwtService.get("userId");
			SessionDomain session = new SessionDomain();
			session.setUserId(userMap.get("userId").toString());
			
			UsernamePasswordAuthenticationToken auth = 
	                new UsernamePasswordAuthenticationToken(session.getUserId(), null, null);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}

}