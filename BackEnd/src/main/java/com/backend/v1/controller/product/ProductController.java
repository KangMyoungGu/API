package com.backend.v1.controller.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.v1.RtCode;
import com.backend.v1.data.entity.RtClass;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;
import com.backend.v1.exception.ApiException;
import com.backend.v1.exception.ParameterException;
import com.backend.v1.service.product.ProductService;

@RestController
@RequestMapping(value="/v1/api/product")
@CrossOrigin
public class ProductController {
	@Autowired ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RtClass getProductList(
			@RequestParam(required = false) String prodCode
	) {
		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());

		try {
			if( "".equals(prodCode) || prodCode == null ) {
				// bestItem 조회
				List<ProdEntity> list = productService.findProductBestItemList();
				rt.setData(list);
				
			} else {
				// 대분류 상품 리스트 조회
				List<ProdEntity> list = productService.selectProductItemList(prodCode);
				rt.setData(list);
			}
			return rt;
		} catch (Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
	
	}
	
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public RtClass getProductInfo(@RequestParam (required = true) String prodCode) {

		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());
		try {
//			if("".equals(prodCode) || prodCode == null) {
//				rt.setRtCode(RtCode.RT_PARAMETER_ERROR.getErrorCode());
//				rt.setRtMsg(RtCode.RT_PARAMETER_ERROR.getErrorMessage());
//			} else {
			return productService.selectProductInfo(prodCode, rt);
//			}

		} catch(ParameterException pe) {
			throw new ParameterException(RtCode.RT_PARAMETER_ERROR);
		} catch (Exception e) {
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}
	}
	
	@RequestMapping(value = "/add/item", method = RequestMethod.POST)
	public RtClass postItem() {
		//개발진행중
		//@RequestParam에 files는 input 객체에 name이다.
		RtClass rt = new RtClass();
		rt.setRtCode(RtCode.RT_SUCCESS.getErrorCode());
		rt.setRtMsg(RtCode.RT_SUCCESS.getErrorMessage());


		try {			
			//productService.insertProductItem(file);
			return rt;
		} catch(ParameterException pe) {
			pe.printStackTrace();
			throw new ParameterException(RtCode.RT_PARAMETER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(RtCode.RT_INTERNAL_ERROR);
		}

	}
}

