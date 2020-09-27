package com.backend.v1.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.data.dto.user.UserDto.LoginDto;
import com.backend.v1.data.dto.user.UserDto.UserInfoDto;
import com.backend.v1.data.entity.user.UserEntity;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;
import com.backend.v1.data.param.user.UserParam.UserSignUpParam;
import com.backend.v1.repository.user.UserRepository;
import com.backend.v1.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	private UserEntity getUser(UserLoginParam param) {
		return null; 	//유저 정보를 db 에서 가져옴
	}
	
	@Override
	public LoginDto login(UserLoginParam param) {
		
		/* repository 가 없어서 주석처리
		if(getUser(param) == null) {
			return null;
		}
		*/
		
		String token = jwtService.createToken(param.getUserId(), param, param.getUserId());
		redisUtil.setRedisDataByString(param.getUserId(), token);
		
		return LoginDto.builder()
				.userId(param.getUserId())
				.token(token)
				.build();
	
	}

	@Override
	public void logout(String userId) {
        redisUtil.deleteRedisData(userId);
	}

	@Override
	public UserInfoDto signUp(UserSignUpParam param) {
		
		return null;
	}

	@Override
	public UserInfoDto getUserInfo() {
		return null;
	}

}
