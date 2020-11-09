package com.backend.v1.data.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.backend.v1.data.enums.OrderStatus;

@Entity(name = "tbl_order_status")
public class OrderStatusEntity {
	
	
	@Id
	@Column(name = "ORDER_STATUS_CD")
	private String orderStatusCode;
	
	/**
	 * 주문 FK
	 */
	@Column(name = "ORDER_CD")
	private String orderCode;
	
	/**
	 * 주문상태
	 */
	@Column(name = "ORDER_STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	/**
	 * 처리일자
	 */
	@Column(name = "PROCESSING_DATE")
	private String procDate;
}
