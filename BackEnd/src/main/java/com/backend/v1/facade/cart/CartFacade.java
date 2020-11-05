package com.backend.v1.facade.cart;

import com.backend.v1.data.entity.RtClass;

public interface CartFacade {

	// 장바구니 아이템 조회
	RtClass selectCartItemList(String userId);

}
