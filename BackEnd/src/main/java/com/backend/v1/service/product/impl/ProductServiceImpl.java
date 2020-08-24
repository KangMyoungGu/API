package com.backend.v1.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.v1.data.entity.product.OuterEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.backend.v1.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired ProductRepository productRepository;
	
	@Override
	public void selectBestItemList() {
		// TODO Auto-generated method stub
		productRepository.findBestItemList();
	}

	@Override
	public List<OuterEntity> selectProductItemList(String prodCode) {
		// TODO Auto-generated method stub
		return productRepository.findProductItemList(prodCode);
	}

}
