package com.backend.v1.data.enums;

public enum OrderStatus {
	
	/**
	 * 상품 준비중
	 */
	PRIPARING_PRODUCT
	
	/**
	 * 배송 준비중
	 */
	, PRIPARING_DELIVER
	
	/**
	 * 배송중
	 */
	, DURING_DELIVERY
	
	/**
	 * 배송 완료
	 */
	, DELIVERY_COMPLETE
	
	/**
	 * 주문 취소
	 */
	, ORDER_CANCELED
}
