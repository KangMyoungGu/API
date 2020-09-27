package com.backend.v1.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.domain.account.SecurityUser;
import com.backend.v1.data.dto.RtClass;
import com.backend.v1.data.dto.user.UserDto.LoginDto;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;
import com.backend.v1.data.param.user.UserParam.UserSignUpParam;
import com.backend.v1.exception.ApiException;
import com.backend.v1.exception.ParameterException;
import com.backend.v1.service.user.UserService;

@RestController
@RequestMapping(value="/v1/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public RtClass<LoginDto> login(@RequestBody @Valid UserLoginParam param){

		RtClass<LoginDto> rt = new RtClass<LoginDto>();
		
		LoginDto dto = userService.login(param);
		
		if(dto == null) {
			throw new ApiException();
		}
		
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		rt.setData(dto);
		
		return rt;
	}
	
	
	@PostMapping("/logout")
	public RtClass<Object> logout(@AuthenticationPrincipal SecurityUser user)
	{
		RtClass<Object> rt = new RtClass<Object>();
		userService.logout(user.getUserId());
		
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		
		return rt;
	}
	
	@PostMapping("/signUp")
	public RtClass<Object> signUp(@RequestBody @Valid UserSignUpParam param, BindingResult result){
		RtClass<Object> rt = new RtClass<Object>();
		
		if(result.hasErrors()) {
			throw new ParameterException(RtCode.RT_PARAMETER_ERROR);  
		}
		
		try {
			
			userService.signUp(param);
			
			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		}catch(Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
		
		
		return rt;
	}

}
