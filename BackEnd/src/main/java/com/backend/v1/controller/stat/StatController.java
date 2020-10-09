package com.backend.v1.controller.stat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.dto.stat.CountOfEachProductDto;
import com.backend.v1.data.entity.RtClass;
import com.backend.v1.exception.ApiException;
import com.backend.v1.service.stat.StatService;

@RestController
@RequestMapping(value="/v1/api/stat")
@CrossOrigin
public class StatController {
	
	@Autowired StatService statService;
	
	@RequestMapping(value="/countOfEachProduct", method = RequestMethod.GET)
	public RtClass getCountOfEachProduct() {
		try {
			RtClass rt = new RtClass();
			rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
			rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
			
			List<CountOfEachProductDto> list = statService.getCountOfEachProduct();
			rt.setData(list);
			
			return rt;
		} catch (Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
	}
}
