package com.backend.v1.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.Exception.ParameterException;
import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.common.util.PropertiesUtil;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.dto.user.UserDto;
import com.backend.v1.data.param.account.UserLoginReqParam;

@RestController
@RequestMapping(value="/v1/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody UserDto postLogin(@RequestBody UserLoginReqParam userLoginReqParam
	){
		if(userLoginReqParam.getLoginId().equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		if(userLoginReqParam.getPassWord().equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		
		// 로그인 성공하면, session을 생성.
		String token = jwtService.createToken(userLoginReqParam.getLoginId(), userLoginReqParam, userLoginReqParam.getLoginId());
		// 1. redis token save
		redisUtil.setRedisDataByString(userLoginReqParam.getLoginId(), token);
		// 2. create session
//		sessionAdapter
		
		UserDto dto = new UserDto();

		dto.setToken(token);
		dto.setUserName("tester1");
		dto.setUserId(userLoginReqParam.getLoginId());
		dto.setPassword(userLoginReqParam.getPassWord());
		
		return dto;
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.DELETE)
	public void deleteLogout(@RequestParam String userId)
	{
		if(userId.equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		redisUtil.deleteRedisData(userId);
	}

}
