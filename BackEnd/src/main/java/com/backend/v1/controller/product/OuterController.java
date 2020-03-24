package com.backend.v1.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.ApiHeader;
import com.backend.v1.RtCode;
import com.backend.v1.adapter.AuthAdapter;
import com.backend.v1.common.util.RedisUtil;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.dto.RtDto;
import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.param.product.OuterListReqParam;
import com.backend.v1.service.product.OuterService;

@RestController
@RequestMapping(value="/v1/api/product/outer")
@CrossOrigin
public class OuterController {
	@Autowired private AuthAdapter authAdapter;
	
	@Autowired private RedisUtil redisUtil;

	@Autowired private TokenUtil tokenUtil;
	
	@Autowired private OuterService outerService;
	
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public @ResponseBody RtDto getOuterList(HttpServletRequest request, @RequestBody OuterListReqParam param) throws IOException {
		RtDto rtDto = new RtDto();
		
		boolean chk = authAdapter.checkAuth(request.getHeader(ApiHeader.TOKEN));
		if(!chk) {
			rtDto.setRtCode(RtCode.RT_TOKEN_INVALID.getErrorCode());
			rtDto.setRtMsg(RtCode.RT_TOKEN_INVALID.getErrorMessage());
			return rtDto;
		}


		rtDto.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rtDto.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		List<OuterDto> result = outerService.selectOuterLists(param);
		System.out.println("outer");
		System.out.println(result);
		if(result.size() > 0) {
			rtDto.setList(result);
		}
		return rtDto;
	}
}
