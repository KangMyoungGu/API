package com.backend.v1.service.product.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.v1.data.dto.product.ProdColorDto;
import com.backend.v1.data.dto.product.ProdSizeDto;
import com.backend.v1.data.entity.RtClass;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.backend.v1.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired ProductRepository productRepository;
	
	@Autowired
	private SqlSession sqlSession;
	
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
		List<ProdColorDto> colorList = productRepository.findProductColorInfo(prodCode);
		List<ProdSizeDto> sizeList = productRepository.findProductSizeInfo(prodCode);
		rt.setData(data);
		rt.setListData(list);
		rt.setColorList(colorList);
		rt.setSizeList(sizeList);
		
		return rt;

	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertProductItem(ProdEntity prodEntity) {
		return 0;
		//return sqlSession.insert(DBUtil.statement(CartRepository.class, "selectCartSeq"), prodEntity);
	}
}
