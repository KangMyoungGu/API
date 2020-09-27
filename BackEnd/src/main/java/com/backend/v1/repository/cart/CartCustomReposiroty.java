package com.backend.v1.repository.cart;

import com.backend.v1.data.dto.cart.CartDetailDto;

public interface CartCustomReposiroty{

	String selectCartSequence(String seqType);
	
	void insertCartDetailList(CartDetailDto cartDetailDto);

}
