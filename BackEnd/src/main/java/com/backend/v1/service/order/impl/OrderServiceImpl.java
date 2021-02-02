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
import com.backend.v1.data.entity.order.OrderStatusEntity;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.user.UserEntity;
import com.backend.v1.data.enums.OrderStatus;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;
import com.backend.v1.exception.ApiException;
import com.backend.v1.repository.order.OrderDetailRepository;
import com.backend.v1.repository.order.OrderRepository;
import com.backend.v1.repository.order.OrderStatusRepository;
import com.backend.v1.repository.product.ProductRepository;
import com.backend.v1.repository.user.UserRepository;
import com.backend.v1.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<OrderDetailDto> getListBy(String userId) {
		
		UserEntity user = userRepository.findByUserId(userId).orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		List<String> orderCodeList = orderRepository.findAllOrderCodeByUserCode(user.getUserCode());
		
		List<OrderDetailEntity> orderDetailEntityList = orderDetailRepository.findAllByOrderCodeIn(orderCodeList);
		
		List<OrderDetailDto> detailListDto = new ArrayList<OrderDetailDto>();
		
		orderDetailEntityList.stream().forEach(o -> {
			
			OrderStatusEntity orderStatus = orderStatusRepository.findByOrderCode(o.getOrderCode());
			ProdEntity prod = productRepository.findProductInfo(o.getProdCode());	//TODO native query 가 더 성능상 좋을 것 같음.
			
			OrderDetailDto detailDto = OrderDetailDto.builder()
					.orderCode(o.getOrderCode())
					.orderDate(o.getRegDate())
					.orderQuantity(o.getOrderQuantity())
					.prodCode(o.getProdCode())
					.prodName(prod.getProdName())
					.prodMasterImagePath(prod.getProdMasterImagePath())
					.prodMasterImageName(prod.getProdMasterImageName())
					.discountedPrice(o.getProdPrice())
					.sellPrice(prod.getSellPrice())
					.orderStatus(orderStatus.getOrderStatus())
					.build();
			
					detailListDto.add(detailDto);
					
		});
		
		return detailListDto;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void postOrder(OrderALLReqParam param, String userId) {
		UserEntity user = userRepository.findByUserId(userId).orElseThrow(() -> new ApiException(RtCode.RT_USER_NOT_FOUND));
		
		
		OrderEntity order = OrderEntity.of(user.getUserCode(), param.getAddrCode());
		order = orderRepository.save(order);
		
		List<OrderDetailEntity> orderDetailEntityList = OrderDetailEntity.ofAll(param, order.getOrderCode());
		orderDetailEntityList.stream().forEach(d -> {
			ProdEntity prod = productRepository.findProductInfo(d.getProdCode());	//TODO native query 가 더 성능상 좋을 것 같음.
			d.validatePriceAndPrice(prod.getSellPrice(), /* TODO 쿠폰 할인률 변수로 */ 10);
		});
		
		orderDetailRepository.saveAll(orderDetailEntityList);
		orderStatusRepository.save(OrderStatusEntity.of(order.getOrderCode(), OrderStatus.PRIPARING_PRODUCT));
	}

}
