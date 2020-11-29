package com.backend.v1.facade.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;
import com.backend.v1.facade.order.OrderFacade;
import com.backend.v1.service.order.OrderService;

@Component
public class OrderFacadeImpl implements OrderFacade {

	@Autowired
	private OrderService orderService;
	
	@Override
	public void postOrder(OrderALLReqParam param, String userId) {
		
	}

}
