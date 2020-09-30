package com.backend.v1.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.RtCode;
import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.data.dto.user.UserDto.LoginDto;
import com.backend.v1.data.dto.user.UserDto.UserInfoDto;
import com.backend.v1.data.entity.user.UserEntity;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;
import com.backend.v1.data.param.user.UserParam.UserSignUpParam;
import com.backend.v1.exception.ApiException;
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
	
	private boolean validateLoginId(String loginId) {
		return userRepository
			.findByLoginId(loginId)
			.isEmpty();
	}
	
	@Override
	public LoginDto login(UserLoginParam param) {
		
		UserEntity user = userRepository.findByLoginId(param.getUserId())
				.orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		
		if(!new BCryptPasswordEncoder().matches(param.getPassword(), user.getPassword())) {
			throw new ApiException(RtCode.RT_USER_NOT_FOUND);
		}

		String token = jwtService.createToken(param.getUserId(), user, param.getUserId());
		redisUtil.setRedisDataByString(param.getUserId(), token);
		
		return LoginDto.builder()
				.userId(param.getUserId())
				.token(token)
				.uuid(user.getUserUUID())
				.build();
	
	}

	@Override
	public void logout(String userId) {
        redisUtil.deleteRedisData(userId);
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public UserInfoDto signUp(UserSignUpParam param) {
		if(!validateLoginId(param.getLoginId())) {
			throw new ApiException();
		}
		
		UserEntity entity = UserEntity.of(param);
		entity = userRepository.save(entity);
		return UserInfoDto.ofEntity(entity);
	}
	
//	@Override
//	public UserInfo get(String userCd)

}
