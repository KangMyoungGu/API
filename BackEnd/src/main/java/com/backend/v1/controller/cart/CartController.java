package com.backend.v1.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.ApiHeader;
import com.backend.v1.RtCode;
import com.backend.v1.common.util.TokenUtil;
import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.entity.RtClass;
import com.backend.v1.data.param.cart.CartParam;
import com.backend.v1.exception.ApiException;
import com.backend.v1.exception.ParameterException;
import com.backend.v1.service.cart.CartService;

@RestController
@RequestMapping(value="/v1/api/cart")
@CrossOrigin
public class CartController {
	@Autowired TokenUtil tokenUtil;
	@Autowired CartService cartService;
	
	@RequestMapping(value = "/{productCode}", method = RequestMethod.POST)
	public RtClass postCartItem(
			@PathVariable (value = "productCode") String productCode
			,@RequestBody (required = true) CartParam param
			,@RequestHeader(value = ApiHeader.TOKEN) String token
	) {
		
		
		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());


		if(param.getItemList().size() == 0) {
			rt.setRtCode(RtCode.RT_PARAMETER_ERROR.getErrorCode());
			rt.setRtMsg(RtCode.RT_PARAMETER_ERROR.getErrorMessage());
			
			return rt;
		}

		try {
			System.out.println("여기!"); 
			SessionDomain sessionDomain = tokenUtil.parseToken(token);
			cartService.insertCartList(sessionDomain,productCode, param);
			

			return rt;
		} catch(ParameterException pe) {
			pe.printStackTrace();
			throw new ParameterException(RtCode.RT_PARAMETER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}

	}

	
}
