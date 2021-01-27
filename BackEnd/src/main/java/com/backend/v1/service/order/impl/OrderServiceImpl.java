package com.backend.v1.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.RtCode;
import com.backend.v1.data.dto.order.OrderDto.OrderDetailDto;
import com.backend.v1.data.entity.order.OrderDetailEntity;
import com.backend.v1.data.entity.order.OrderEntity;
import com.backend.v1.data.entity.user.UserEntity;
import com.backend.v1.data.enums.OrderStatus;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;
import com.backend.v1.data.param.order.OrderParam.OrderReqParam;
import com.backend.v1.exception.ApiException;
import com.backend.v1.repository.order.OrderDetailRepository;
import com.backend.v1.repository.order.OrderRepository;
import com.backend.v1.repository.user.UserRepository;
import com.backend.v1.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	int i = 0;
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<OrderDetailDto> getListBy(String userId) {
		
		UserEntity user = userRepository.findByUserId(userId).orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		List<String> orderCodeList = orderRepository.findAllOrderCodeByUserCode(user.getUserCode());
		
		List<OrderDetailEntity> orderDetailEntityList = orderDetailRepository.findAllByOrderCodeIn(orderCodeList);
		
		List<OrderDetailDto> detailListDto = new ArrayList<OrderDetailDto>();
		
		
		
		orderDetailEntityList.stream().forEach(o -> {
			
			OrderDetailDto detailDto = OrderDetailDto.builder()
					.orderCode(o.getOrderCode())
					.orderDate(o.getRegDate())
					.orderQuantity(o.getOrderQuantity())
					.prodCode("codododoe" + i)
					.prodName("바지")
					.discountedPrice("25000")
					.sellPrice("3000")
					.orderStatus(OrderStatus.COMPLETED)
					.build();
			
					detailListDto.add(detailDto);
					
					i++;
		});
		
		return detailListDto;
	}

	@Override
	public void postOrder(OrderALLReqParam param, String userId) {
		UserEntity user = userRepository.findByUserId(userId).orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		
		OrderEntity order = OrderEntity.of(user.getUserCode(), param.getAddrCode());
		order = orderRepository.save(order);
		
		List<OrderDetailEntity> orderDetailEntityList = OrderDetailEntity.ofAll(param, order.getOrderCode());
		
		orderDetailRepository.saveAll(orderDetailEntityList);
	}

}
