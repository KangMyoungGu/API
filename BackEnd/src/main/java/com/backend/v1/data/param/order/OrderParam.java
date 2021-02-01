package com.backend.v1.data.param.order;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderParam {

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	@ToString
	public static class OrderReqParam {
		
		/**
		 * 주문할 상품 코드
		 */
		private String prodCode;
		
		/**
		 * 상품 수량
		 */
		private Integer count;
		
		/**
		 * 주문할 상품 개별에 들어간 쿠폰 코드
		 */
		private String couponCode;
		
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	@ToString
	public static class OrderALLReqParam{
		private List<OrderReqParam> orderParamList;
		private String addrCode;
	}
}
