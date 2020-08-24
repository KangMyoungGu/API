package com.backend.v1.service.product;

import java.util.List;

import com.backend.v1.data.entity.product.ProdEntity;


public interface ProductService {

	List<ProdEntity> findProductBestItemList();

	List<ProdEntity> selectProductItemList(String prodCode);


}
