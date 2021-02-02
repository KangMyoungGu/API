package com.backend.v1.data.dto.order;

import com.backend.v1.data.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class OrderDto {
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class OrderDetailDto {
		
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
		 * 수량
		 */
		private Integer orderQuantity;
		
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
		 * 상품대표이미지경로
		 */
		private String prodMasterImagePath;
		
		/**
		 * 대표이미지파일명
		 */
		private String prodMasterImageName;
		
		/**
		 * 주문상태
		 */
		private OrderStatus orderStatus;
	}
}
