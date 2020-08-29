package com.backend.v1.data.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


public class UserDto {

	@Getter
    @AllArgsConstructor
    @Builder
	public static class LoginDto {
		private String token;
		private String userId;
	}
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class UserInfoDto {
		private String loginId;
		private String password;
		private String email;
		private String name;
		private String phoneNumber;
		private String userBirth;
		private String regDate;
		private String modDate;
	}
}
