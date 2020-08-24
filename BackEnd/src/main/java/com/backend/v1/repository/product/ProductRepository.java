package com.backend.v1.repository.product;

import java.util.List;

import com.backend.v1.data.entity.product.OuterEntity;

public interface ProductRepository {

	void findBestItemList();

	List<OuterEntity> findProductItemList(String prodCode);

}
