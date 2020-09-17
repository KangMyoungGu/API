package com.backend.v1.service.cart;

import java.util.List;

import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.param.cart.CartParam;

public interface CartService {

	// 장바구니 저장
	int insertCartList(SessionDomain sessionDomain, String productCode, CartParam param);

}
