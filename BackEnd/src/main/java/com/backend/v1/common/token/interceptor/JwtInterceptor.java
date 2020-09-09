package com.backend.v1.common.token.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.backend.v1.ApiHeader;
import com.backend.v1.RtCode;
import com.backend.v1.Exception.UnauthorizedException;
import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.domain.account.SessionDomain;

@Component
public class JwtInterceptor implements HandlerInterceptor{

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		JSONObject jsonObj = new JSONObject();
		
		
		if (StringUtils.equals(request.getMethod(), "OPTIONS")) {
			return true;
		} else {
			// 헤더에 토큰이 없을 경우
			if(request.getHeader(ApiHeader.TOKEN) == null || "".equals(request.getHeader(ApiHeader.TOKEN))) {
				jsonObj.put("rtCode", RtCode.RT_TOKEN_NOT_FOUND.getErrorCode());
				jsonObj.put("rtMsg", RtCode.RT_TOKEN_NOT_FOUND.getErrorMessage());
				response.setContentType("application/json");
				response.setStatus(RtCode.RT_TOKEN_NOT_FOUND.getHttpStatus().value());
				response.getWriter().write(jsonObj.toString());;
				
				return false;
			}
			
			// 토큰이 변조 되었을 경우
			if(!jwtService.isUsable(request.getHeader(ApiHeader.TOKEN))) {
				jsonObj.put("rtCode", RtCode.RT_TOKEN_NOT_FORGERY.getErrorCode());
				jsonObj.put("rtMsg", RtCode.RT_TOKEN_NOT_FORGERY.getErrorMessage());
				response.setContentType("application/json");
				response.setStatus(RtCode.RT_TOKEN_NOT_FORGERY.getHttpStatus().value());
				response.getWriter().write(jsonObj.toString());;
				
				return false;
			}
			
			SessionDomain sessionDomain = new TokenUtil().parseToken(request.getHeader(ApiHeader.TOKEN));
			
			// 토큰은 정상이나, 요청한 사람의 token 정보가 아닐 경우 - api에 userId가 pathvariable로 요청 ( post 방식 )
			Map<?,?> pathVariables = (Map<?,?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			if(pathVariables.size() > 0) {
				if(pathVariables.get("userId") != null) {
					if(!pathVariables.get("userId").equals(sessionDomain.getUserId())) {
						jsonObj.put("rtCode", RtCode.RT_TOKEN_NOT_FORGERY.getErrorCode());
						jsonObj.put("rtMsg", RtCode.RT_TOKEN_NOT_FORGERY.getErrorMessage());
						response.setContentType("application/json");
						response.setStatus(RtCode.RT_TOKEN_NOT_FORGERY.getHttpStatus().value());
						response.getWriter().write(jsonObj.toString());;
						
						return false;
					}				
				}
			}
			
			// 토큰은 정상이나, 요청한 사람의 token 정보가 아닐 경우 - api에 userId가 RequestParameter로 요청 ( get 방식 )
			if(request.getParameter("userId") != null && !"".equals(request.getParameter("userId"))) {
				if(!request.getParameter("userId").equals(sessionDomain.getUserId())) {
					jsonObj.put("rtCode", RtCode.RT_TOKEN_NOT_FORGERY.getErrorCode());
					jsonObj.put("rtMsg", RtCode.RT_TOKEN_NOT_FORGERY.getErrorMessage());
					response.setContentType("application/json");
					response.setStatus(RtCode.RT_TOKEN_NOT_FORGERY.getHttpStatus().value());
					response.getWriter().write(jsonObj.toString());;
					
					return false;
				}
			}
			
			// 토큰은 정상이나, 요청한 사람의 token 정보가 아닐 경우 - api에 userId가 RequestBody로 요청 ( post 방식 )
			String strRequestBody = request.getAttribute("requestBody").toString();
			if(!strRequestBody.equals("")) {
				JSONObject jsonRequestBody = new JSONObject(strRequestBody);
				
				if(jsonRequestBody.get("userId") != null) {
					if(!jsonRequestBody.get("userId").equals(sessionDomain.getUserId())) {
						jsonObj.put("rtCode", RtCode.RT_TOKEN_NOT_FORGERY.getErrorCode());
						jsonObj.put("rtMsg", RtCode.RT_TOKEN_NOT_FORGERY.getErrorMessage());
						response.setContentType("application/json");
						response.setStatus(RtCode.RT_TOKEN_NOT_FORGERY.getHttpStatus().value());
						response.getWriter().write(jsonObj.toString());;
						
						return false;
					}
				}
			}
	
			return true;
		}
	}
}
