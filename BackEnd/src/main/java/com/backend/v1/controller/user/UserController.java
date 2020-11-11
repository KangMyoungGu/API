package com.backend.v1.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.domain.account.RequestUser;
import com.backend.v1.data.dto.RtClass;
import com.backend.v1.data.dto.user.UserDto.LoginDto;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;
import com.backend.v1.data.param.user.UserParam.UserSignUpParam;
import com.backend.v1.exception.ApiException;
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
		
		try {
			LoginDto dto = userService.login(param);
			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
			rt.setData(dto);
		}catch(ApiException e) {
			throw new ApiException(RtCode.RT_USER_NOT_FOUND);
		}catch(Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
		
		return rt;
	}
	
	
	@PostMapping("/logout")
	public RtClass<Object> logout(@AuthenticationPrincipal RequestUser user)
	{
		RtClass<Object> rt = new RtClass<Object>();
		userService.logout(user.getUserId());
		
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		
		return rt;
	}
	
	@PostMapping("/signUp")
	public RtClass<Object> signUp(@RequestBody @Valid UserSignUpParam param){
		RtClass<Object> rt = new RtClass<Object>();
		
		try {
			
			userService.signUp(param);
			
			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		}catch(ApiException e) {
			throw new ApiException(RtCode.RT_CONFICT_USER_LOGIN_ID);
		}catch(Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
		
		
		return rt;
	}
	
//	/**
//	 * @apiNote 회원 자신의 정보 조회 API
//	 */
//	@Secured({"ROLE_ADMIN", "ROLE_USER"})
//	@GetMapping("/myinfo")
//	public RtClass<Object> get(@AuthenticationPrincipal SecurityUser user){
//		RtClass<Object> rt = new RtClass<Object>();
//		
//		try {
//			
//			
//			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
//			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
//			rt.setDat
//		}catch(Exception e) {
//			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
//		}
//		
//		
//		return rt;
//	}
//	
//	/**
//	 * @apiNote 모든 회원 리스트 조회 API
//	 */
//	@Secured("ROLE_ADMIN")
//	@GetMapping("")
//	public RtClass<Object> getList(@AuthenticationPrincipal SecurityUser user){
//		RtClass<Object> rt = new RtClass<Object>();
//		
//		try {
//			
//			userService.get(param);
//			
//			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
//			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
//		}catch(Exception e) {
//			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
//		}
//		
//		
//		return rt;
//	}

}
