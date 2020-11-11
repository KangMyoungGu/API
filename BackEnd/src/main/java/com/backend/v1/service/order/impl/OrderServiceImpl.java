package com.backend.v1.service.order.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.data.dto.order.OrderDto.OrderListDto;
import com.backend.v1.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<OrderListDto> getListBy(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
