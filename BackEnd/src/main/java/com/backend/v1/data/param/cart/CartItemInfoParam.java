package com.backend.v1.data.param.cart;

import lombok.Data;

@Data
public class CartItemInfoParam {
	private String colorCode;
	private String sizeCode;
	private int orderCount;
	private int orderPrice;
	private int sort;
}
