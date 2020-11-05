package com.backend.v1.data.dto.cart;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String cartCd;
	private String userId;
	private String userNo;
	private String cartTotalCount;
	private String cartTotalPrice;
	private String cartRegDate;
	private String cartExpDate;
	private String cartExPYn;
}
