package com.backend.v1.data.entity.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.backend.v1.common.util.DateUtil;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;

import lombok.Builder;

@Builder
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
	private String prodCode;
	
	/**
	 * 제품수량
	 */
	@Column(name = "ORDER_QUANTITY")
	private Integer orderQuantity;
	
	/**
	 * 할인가포함 상품당 주문 금액
	 */
	@Column(name = "PRODUCT_PRICE")
	private String prodPrice;
	
	/**
	 * 쿠폰 FK
	 */
	@Column(name = "COUPON_CD")
	private String couponCode;
	
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
	
	public static List<OrderDetailEntity> ofAll(OrderALLReqParam param, String orderCode) {
		
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssssss");
		
		List<OrderDetailEntity> detailList = new ArrayList<OrderDetailEntity>();
		param.getOrderParamList().stream().forEach(o -> {
			OrderDetailEntity entity = OrderDetailEntity.builder()
					.orderProdCode(String.format("OD%s", format.format(Calendar.getInstance().getTime())))
					.orderCode(orderCode)
					.prodCode(o.getProdCode())
					.orderQuantity(o.getCount())
					.couponCode(o.getCouponCode())
					.regDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
					.modDate(new DateUtil().getTodayByString("yyyy-MM-dd HH:mm:ss"))
					.build();
			detailList.add(entity);
		});
		
		return detailList;
	}
	
	public static OrderDetailEntity validateAndGetPrice() {
		return null;
	}
}
