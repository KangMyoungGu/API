package com.backend.v1.data.entity.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.backend.v1.common.util.DateUtil;
import com.backend.v1.data.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity(name = "tbl_order_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
	
	/**
	 * row 생성일자
	 */
	@Column(name = "REG_DATE")
	private String regDate;
	
	/**
	 * row 수정일자
	 */
	@Column(name = "MODE_DATE")
	private String modDate;
	
	public static OrderStatusEntity of(String orderCode, OrderStatus orderStatus) {
		
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssssss");
		String dateStr = format.format(Calendar.getInstance().getTime());
		
		return OrderStatusEntity.builder()
				.orderStatusCode(String.format("OS%s", dateStr))
				.orderCode(orderCode)
				.orderStatus(orderStatus)
				.procDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.regDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.modDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.build();
	}

}
