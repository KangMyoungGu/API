package com.backend.v1.data.dto.user;

import com.backend.v1.data.entity.user.UserEntity;

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
		private String uuid;
	}
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class UserInfoDto {
		private String userId;
		private String password;
		private String email;
		private String name;
		private String phoneNumber;
		private String userBirth;
		private String regDate;
		private String modDate;
		
		public static UserInfoDto ofEntity(UserEntity entity) {
			return UserInfoDto.builder()
					.userId(entity.getUserId())
					.email(entity.getEmail())
					.name(entity.getName())
					.phoneNumber(entity.getPhoneNumber())
					.userBirth(entity.getUserBirth())
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
					.build();
		}
	}
}
