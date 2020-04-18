package com.backend.v1.controller.account;

import com.backend.v1.data.dto.RtDto;
import com.backend.v1.data.dto.account.AccountDto;
import com.backend.v1.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
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
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.param.account.UserLoginReqParam;

@RestController
@RequestMapping(value="/v1/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody
	RtDto<SessionDomain> postLogin(@RequestBody UserLoginReqParam userLoginReqParam
	){
		if(userLoginReqParam.getLoginId().equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		if(userLoginReqParam.getPassWord().equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		RtDto<SessionDomain> rtDto = new RtDto<>();
		AccountDto accountDto = accountService.getAccount(userLoginReqParam);

		try{
			if(accountDto != null) {
				if(accountDto.getACCOUNT_PW().equals(userLoginReqParam.getPassWord())) {

					String token = jwtService.createToken(userLoginReqParam.getLoginId(), userLoginReqParam, userLoginReqParam.getLoginId());
					redisUtil.setRedisDataByString(userLoginReqParam.getLoginId(), token);

					SessionDomain sessionDomain = new SessionDomain(userLoginReqParam.getLoginId(), token);

					rtDto.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
					rtDto.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());

					rtDto.setRtData(sessionDomain);
				} else{
					rtDto.setRtCode(RtCode.RT_LOGIN_PASSWORD_WRONG.getErrorCode());
					rtDto.setRtMsg(RtCode.RT_LOGIN_PASSWORD_WRONG.getErrorMessage());
				}

			} else{
				rtDto.setRtCode(RtCode.RT_USER_NOT_FOUND.getErrorCode());
				rtDto.setRtMsg(RtCode.RT_USER_NOT_FOUND.getErrorMessage());
			}
		}catch (Exception e){
			rtDto.setRtCode(RtCode.RT_INTERNAL_ERROR.getErrorCode());
			rtDto.setRtMsg(RtCode.RT_INTERNAL_ERROR.getErrorMessage());
		}
		return rtDto;
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.DELETE)
	public void deleteLogout(@RequestParam String userId)
	{
		if(userId.equals("")) throw new ParameterException(RtCode.RT_PARAMETER_ERROR);

		redisUtil.deleteRedisData(userId);
	}

}
