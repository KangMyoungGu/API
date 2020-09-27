package com.backend.v1.data.param.cart;

import java.util.List;

import lombok.Data;

@Data
public class CartParam {
	private String cartCd;
	private String userId;
	private int totalPrice;
	private int totalCount;
	private List<CartItemInfoParam> itemList;
}
