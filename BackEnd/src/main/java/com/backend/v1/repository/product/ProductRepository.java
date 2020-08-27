package com.backend.v1.repository.product;

import java.util.List;

import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;


public interface ProductRepository{

	List<ProdEntity> findProductBestItemList();

	List<ProdEntity> findProductItemList(String prodCode);

	ProdEntity findProductInfo(String prodCode);

	List<ProdInfoEntity> findProductDetailImage(String prodCode);

}
