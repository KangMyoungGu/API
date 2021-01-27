package com.backend.v1.data.entity.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.backend.v1.common.util.DateUtil;
import com.backend.v1.data.enums.Role;
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
	private String userId;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;
	
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
	
	@Column(name = "USER_UUID")
	private String userUUID;
	
	public static UserEntity of(UserSignUpParam param) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssssss");
		String dateStr = format.format(Calendar.getInstance().getTime());

		return UserEntity.builder()
				.userCode(String.format("US%s", dateStr))
				.userId(param.getUserId())
				.password(new BCryptPasswordEncoder().encode(param.getPassword()))
				.role(Role.USER)
				.email(param.getEmail())
				.name(param.getName())
				.phoneNumber(param.getPhoneNumber())
				.userBirth(param.getUserBirth())
				.regDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.modDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.userUUID(UUID.randomUUID().toString().replaceAll("-", ""))
				.build();
	}
}
