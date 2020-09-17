package com.backend.v1.service.cart.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.common.util.DateUtil;
import com.backend.v1.data.domain.account.SessionDomain;
import com.backend.v1.data.dto.cart.CartDetailDto;
import com.backend.v1.data.entity.cart.CartMasterEntity;
import com.backend.v1.data.param.cart.CartItemInfoParam;
import com.backend.v1.data.param.cart.CartParam;
import com.backend.v1.repository.cart.CartRepository;
import com.backend.v1.service.cart.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired CartRepository cartRepository;
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertCartList(SessionDomain sessionDomain, String productCode, CartParam param) {
		String cartSeqCode = cartRepository.selectCartSequence("cart");
		
		param.setCartCd(sessionDomain.getUserNo() + new DateUtil().getTodayByString("yyyyMMddHHmmss") + cartSeqCode) ;
		
		CartMasterEntity cartMasterEntity = new CartMasterEntity();
		cartMasterEntity.setCartCd(param.getCartCd());
		cartMasterEntity.setUserId(sessionDomain.getUserId());
		cartMasterEntity.setUserNo(sessionDomain.getUserNo());
		cartMasterEntity.setCartTotalPrice(param.getTotalPrice());
		cartMasterEntity.setCartTotalCount(param.getTotalCount());
		cartMasterEntity.setCartRegDate(new DateUtil().getToday());
		cartMasterEntity.setCartExpDate(new DateUtil().getWantDay(7));
		cartMasterEntity.setCartExpYn("N");
		
		cartRepository.save(cartMasterEntity);
		
		// 이 아래에 cartDetail insert 추가
		
		int idx = 0;
		for(CartItemInfoParam item  : param.getItemList()) {
			CartDetailDto cartDetailDto = new CartDetailDto();
			cartDetailDto.setCartCd(param.getCartCd());
			cartDetailDto.setProdCd(productCode);
			cartDetailDto.setProdColorCd(item.getColorCode());
			cartDetailDto.setProdCount(item.getOrderCount());
			cartDetailDto.setProdPrice(item.getOrderPrice());
			cartDetailDto.setProdSizeCd(item.getSizeCode());
			cartDetailDto.setSort(idx ++);
			
			cartRepository.insertCartDetailList(cartDetailDto);
		}

		
		
		return 0;
	}

}
