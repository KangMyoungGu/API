package com.backend.v1.data.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class UserDto implements Serializable {
	private static final long serialVersionUID = -2536624275594456755L;
	private String token;
	private String userId;
	private String userName;
	private String password;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
