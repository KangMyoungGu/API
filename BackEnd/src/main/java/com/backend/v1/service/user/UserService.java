package com.backend.v1.service.user;

import com.backend.v1.data.dto.user.UserDto.LoginDto;
import com.backend.v1.data.dto.user.UserDto.UserInfoDto;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;
import com.backend.v1.data.param.user.UserParam.UserSignUpParam;

public interface UserService {
	LoginDto login(UserLoginParam param);
	void logout(String userId);
	UserInfoDto signUp(UserSignUpParam param);
	UserInfoDto getUserInfo();
}
