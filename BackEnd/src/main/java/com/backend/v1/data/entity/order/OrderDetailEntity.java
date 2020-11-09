package com.backend.v1.data.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_order_detail")
public class OrderDetailEntity {
	
	@Id
	@Column(name = "ORDER_DETAIL_CD")
	private String orderProdCode;
	
	/**
	 * 주문코드 FK
	 */
	@Column(name = "ORDER_CD")
	private String orderCode;
	
	/**
	 * 상품코드 FK
	 */
	@Column(name = "PRODUCT_CD")
	private String productCode;
	
	/**
	 * 제품수량
	 */
	@Column(name = "ORDER_QUANTITY")
	private String orderQuantity;
	
}
