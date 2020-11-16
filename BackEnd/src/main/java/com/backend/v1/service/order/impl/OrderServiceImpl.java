package com.backend.v1.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.RtCode;
import com.backend.v1.data.dto.order.OrderDto.OrderListDto;
import com.backend.v1.data.entity.order.OrderEntity;
import com.backend.v1.data.entity.user.UserEntity;
import com.backend.v1.exception.ApiException;
import com.backend.v1.repository.order.OrderRepository;
import com.backend.v1.repository.user.UserRepository;
import com.backend.v1.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<OrderListDto> getListBy(String userId) {
		
		UserEntity user = userRepository.findByUserId(userId).orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		List<OrderEntity> orderList = orderRepository.findByUserCode(user.getUserCode());
		
		return null;
	}

}
