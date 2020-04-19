package com.backend.v1.data.param.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginReqParam {
	private String loginId;
	private String passWord;
}
