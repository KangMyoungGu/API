package com.backend.v1.data.dto.order;

import com.backend.v1.data.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class OrderDto {
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class OrderListDto {
		String orderCode;
		String orderDate;
		String productPrice;
		OrderStatus orderStatus;
	}
}
