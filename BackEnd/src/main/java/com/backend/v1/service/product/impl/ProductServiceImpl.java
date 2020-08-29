package com.backend.v1.service.product.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.v1.data.entity.RtClass;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.backend.v1.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired ProductRepository productRepository;
	
	@Override
	public List<ProdEntity> findProductBestItemList() {
		// TODO Auto-generated method stub
		return productRepository.findProductBestItemList();
	}

	@Override
	public List<ProdEntity> selectProductItemList(String prodCode) {
		// TODO Auto-generated method stub
		return productRepository.findProductItemList(prodCode);
	}

	@Override
	public RtClass selectProductInfo(String prodCode, RtClass rt) {
		ProdEntity data = productRepository.findProductInfo(prodCode);
		List<ProdInfoEntity> list = productRepository.findProductDetailImage(prodCode);
		rt.setData(data);
		rt.setListData(list);
		
		return rt;

	}

}
