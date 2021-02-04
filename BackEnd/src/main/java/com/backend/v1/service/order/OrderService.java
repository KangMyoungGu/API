package com.backend.v1.service.order;

import java.util.List;

import com.backend.v1.data.dto.order.OrderDto.OrderDetailDto;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;

public interface OrderService {

	List<OrderDetailDto> getListBy(String userId);

	void postOrder(OrderALLReqParam param, String userId);
	
	/**
	 * <p>주문 취소</p>
	 * <p>상품 준비중, 배송 준비중 상태에서만 주문 취소 가능함</p>
	 * 
	 * @param userCode
	 * @param orderCode
	 */
	void cancelOrder(String userCode, String orderCode);
}
