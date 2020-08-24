package com.backend.v1.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.data.entity.product.OuterEntity;
import com.backend.v1.service.product.ProductService;

@RestController
@RequestMapping(value="/v1/api/product")
@CrossOrigin
public class ProductController {
	@Autowired ProductService productService;

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<OuterEntity> getProductList(
			@RequestParam(required = false) String prodCode
	) {
		if( "".equals(prodCode) || prodCode == null ) {
			// bestItem 조회
			//productService.selectBestItemList();
			return null;
		} else {
			// 대분류 상품 리스트 조회
			return productService.selectProductItemList(prodCode);
		}
	}
}
