package com.backend.v1.facade.cart.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.v1.RtCode;
import com.backend.v1.data.entity.RtClass;
import com.backend.v1.facade.cart.CartFacade;
import com.backend.v1.service.cart.CartService;

@Component
public class CartFacadeImpl implements CartFacade{

	@Autowired private CartService cartService;
	
	@Override
	public RtClass selectCartItemList(String userId) {
		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		rt.setData(cartService.selectCartList(userId));
		rt.setListData(cartService.selectCartItemList(userId));
		
		return rt;
		
	}
	

}
