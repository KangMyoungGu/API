package com.backend.v1.data.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.backend.v1.data.enums.OrderStatus;

@Entity(name = "tbl_order")
public class OrderEntity {

	/**
	 * 주문고유번호
	 */
	@Id
	@Column(name = "ORDER_CD")
	private String orderCode;	
	
	/**
	 * 주문날짜
	 */
	@Column(name = "ORDER_DATE")
	private String orderDate;
	
	/**
	 * 주문자 FK
	 */
	@Column(name = "USER_CD")
	private String userCode;
	
	/**
	 * 배송주소 FK
	 */
	@Column(name = "ADDR_CD")
	private String addrCode;
	
	/**
	 * 쿠폰 FK
	 */
	@Column(name = "COUPON_CD")
	private String couponCode;
	
}
