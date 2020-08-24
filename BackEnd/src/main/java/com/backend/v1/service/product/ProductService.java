package com.backend.v1.service.product;

import java.util.List;

import com.backend.v1.data.entity.product.OuterEntity;

public interface ProductService {

	void selectBestItemList();

	List<OuterEntity> selectProductItemList(String prodCode);


}
