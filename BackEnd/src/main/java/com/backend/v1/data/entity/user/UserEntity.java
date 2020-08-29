package com.backend.v1.data.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.backend.v1.data.param.user.UserParam.UserSignUpParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "tbl_user")
public class UserEntity {
	
	@Id
	@Column(name = "USER_CD")
	private String userCode;
	
	@Column(name = "USER_ID")
	private String loginId;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_PHONE")
	private String phoneNumber;
	
	@Column(name = "USER_BIRTH")
	private String userBirth;
	
	@Column(name = "REG_DATE")
	private String regDate;
	
	@Column(name = "MODE_DATE")
	private String modDate;
	
	public static UserEntity of(UserSignUpParam param) {
		return UserEntity.builder()
				.loginId(param.getLoginId())
				.password(param.getPassword())
				.email(param.getEmail())
				.name(param.getName())
				.phoneNumber(param.getPhoneNumber())
				.userBirth(param.getUserBirth())
				.build();
	}
}
