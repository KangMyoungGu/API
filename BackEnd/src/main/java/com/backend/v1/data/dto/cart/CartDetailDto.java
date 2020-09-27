package com.backend.v1.data.dto.cart;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartDetailDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String cartCd;
	private String prodCd;
	private String prodColorCd;
	private String prodSizeCd;
	private int prodCount;
	private int prodPrice;
	private int sort;

}
