package com.backend.v1.common.token.service;

import java.util.Map;

public interface JwtService {
	public <T> String createToken(String key, T data, String subject);
	
	public Map<String, Object> get(String key);
	
	public boolean isUsable(String jwt);
}
