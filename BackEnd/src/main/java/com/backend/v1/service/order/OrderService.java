package com.backend.v1.service.order;

import java.util.List;

import com.backend.v1.data.dto.order.OrderDto.OrderDetailDto;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;

public interface OrderService {

	List<OrderDetailDto> getListBy(String userId);

	void postOrder(OrderALLReqParam param, String userId);
}
