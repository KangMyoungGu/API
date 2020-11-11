package com.backend.v1.service.order;

import java.util.List;

import com.backend.v1.data.dto.order.OrderDto.OrderListDto;

public interface OrderService {

	List<OrderListDto> getListBy(String userId);

}
