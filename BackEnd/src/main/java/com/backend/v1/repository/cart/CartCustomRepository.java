package com.backend.v1.repository.cart;

import java.util.List;

import com.backend.v1.data.dto.cart.CartDetailDto;
import com.backend.v1.data.entity.cart.CartDetailEntity;
import com.backend.v1.data.entity.cart.CartMasterEntity;

public interface CartCustomRepository{

	String selectCartSequence(String seqType);
	
	void insertCartDetailList(CartDetailDto cartDetailDto);

	List<CartMasterEntity> selectCartList(String userId);

	List<CartDetailEntity> selectCartItemList(String userId);

}
