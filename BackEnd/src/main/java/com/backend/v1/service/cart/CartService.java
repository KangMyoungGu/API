package com.backend.v1.service.cart;

import java.util.List;

import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.entity.cart.CartDetailEntity;
import com.backend.v1.data.entity.cart.CartMasterEntity;
import com.backend.v1.data.param.cart.CartParam;

public interface CartService {

	// 장바구니 저장
	int insertCartList(SessionDomain sessionDomain, String productCode, CartParam param);
	
	// 장바구니 조회
	List<CartMasterEntity> selectCartList(String userId);

	// 장바구니 별 상품리스트 조회
	List<CartDetailEntity> selectCartItemList(String userId);

}
