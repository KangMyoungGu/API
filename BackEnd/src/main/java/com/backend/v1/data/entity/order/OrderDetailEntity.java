package com.backend.v1.data.entity.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.backend.v1.common.util.DateUtil;
import com.backend.v1.data.param.order.OrderParam.OrderALLReqParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity(name = "tbl_order_detail")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {
	
	@Id
	@Column(name = "ORDER_DETAIL_CD")
	private String orderDetailCode;
	
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
		
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		List<OrderDetailEntity> detailList = new ArrayList<OrderDetailEntity>();
		param.getOrderParamList().stream().forEach(o -> {
			OrderDetailEntity entity = OrderDetailEntity.builder()
					.orderDetailCode(String.format("OD%s%s", format.format(Calendar.getInstance().getTime()),
							UUID.randomUUID().toString().substring(0, 2)))
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
	
	/**
	 * <p>상품 정가와 쿠폰 할인률(%) 를 입력받아 주문 금액을 계산한다</p> 
	 * 
	 * @param price 상품 정가
	 * @param discountPercent 쿠폰 할인률(0~100) %
	 */
	public void validatePriceAndPrice(String price, Integer discountPercent) {
		Integer priceInt = Integer.parseInt(price);
		priceInt = (priceInt*(100-discountPercent))/100;
		price = priceInt.toString();
		this.prodPrice = price;
	}
}
