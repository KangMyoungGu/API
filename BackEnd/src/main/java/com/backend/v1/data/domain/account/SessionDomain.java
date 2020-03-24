package com.backend.v1.data.domain.account;

public class SessionDomain {
	// Javascript Data type Number != Java Long type. so use userNo as cast String
	private String userId;
	private String token;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
