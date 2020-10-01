package com.backend.v1.data.param.user;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserParam {
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
    @Builder
	public static class UserLoginParam {
		@NotEmpty
		private String userId;
		@NotEmpty
		private String password;
	}
	
	@Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	public static class UserSignUpParam {
		@NotEmpty
		private String userId;
		@NotEmpty
		private String password;
		@NotEmpty @Email
		private String email;
		@NotEmpty
		private String name;
		@NotEmpty @Pattern(regexp = "^010[-](\\d{3}|\\d{4})[-](\\d{3}|\\d{4})$")	// 010-XXXX-XXXX
		private String phoneNumber;
		@NotEmpty
		private String userBirth;
	}
	
}
