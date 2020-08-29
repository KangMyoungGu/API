package com.backend.v1.controller.test;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.common.token.service.JwtService;
import com.backend.v1.data.param.user.UserParam.UserLoginParam;

@RestController
@RequestMapping(value="/v1/api/test")
@CrossOrigin
public class TestController {
	@Autowired JwtService jwtService;
	
	@RequestMapping(value="/maketoken", method = RequestMethod.GET)
	public HashMap<String, Object> createToken(@RequestParam("userId") String userId) {
		UserLoginParam param = UserLoginParam.builder()
				.userId(userId)
				.build();
		
		String token = jwtService.createToken(param.getUserId(), param, param.getUserId());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		map.put("userId", userId);
		return map;
	}
}
