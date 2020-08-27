package com.backend.v1.service.product;

import java.util.List;

import com.backend.v1.data.entity.RtClass;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;


public interface ProductService {

	// 베스트 상품 리스트
	List<ProdEntity> findProductBestItemList();

	// 상품 리스트
	List<ProdEntity> selectProductItemList(String prodCode);

	// 상품 상세 정보
	RtClass selectProductInfo(String prodCode, RtClass rt);


}
