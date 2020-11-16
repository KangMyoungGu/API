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
		
		/**
		 * 주문번호
		 */
		private String orderCode;
		
		/**
		 * 주문일자
		 */
		private String orderDate;
		
		/**
		 * 할인가
		 */
		private String discountedPrice; 
		
		/**
		 * 상품코드
		 */
		private String prodCode;
		
		/**
		 * 상품명 
		 */
		private String prodName;
		
		/**
		 * 상품가격(정가)
		 */
		private String sellPrice;
		
		/**
		 * 주문상태
		 */
		private OrderStatus orderStatus;
	}
}
