package com.backend.v1.data.entity.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.backend.v1.common.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Entity(name = "tbl_order")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	 * row 생성일자
	 */
	@Column(name = "REG_DATE")
	private String regDate;
	
	/**
	 * row 수정일자
	 */
	@Column(name = "MODE_DATE")
	private String modDate;
	
	public static OrderEntity of(String userCode, String addrCode) {

		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssssss");
		String dateStr = format.format(Calendar.getInstance().getTime());

		return OrderEntity.builder()
				.orderCode(String.format("OR%s", dateStr))
				.orderDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.userCode(userCode)
				.addrCode(addrCode)
				.regDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.modDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
				.build();
	}
}
