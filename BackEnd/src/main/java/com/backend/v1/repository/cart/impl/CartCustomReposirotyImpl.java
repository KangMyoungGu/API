package com.backend.v1.repository.cart.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.backend.v1.common.util.DBUtil;
import com.backend.v1.data.dto.cart.CartDetailDto;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.repository.cart.CartCustomReposiroty;
import com.backend.v1.repository.cart.CartRepository;
import com.backend.v1.repository.product.ProductRepository;
import com.mysema.query.jpa.impl.JPAQuery;


@Repository
public class CartCustomReposirotyImpl implements CartCustomReposiroty{
	// mybatis 쓸려면 이거 사용하면 된다.
	@Autowired
	private SqlSession sqlSession;
	
	private @PersistenceContext EntityManager entityManager;

	@Override
	public String selectCartSequence(String seqType) {
		return sqlSession.selectOne(DBUtil.statement(CartRepository.class, "selectCartSeq"), seqType);
	}

	@Override
	public void insertCartDetailList(CartDetailDto cartDetailDto) {
		// Mybatis로 바꿀까....흠...
		entityManager.createNativeQuery(
				"INSERT INTO TBL_CART_DETAIL"
				+ "("
				+ "CART_CD, PROD_CD, PROD_COLOR_CD, PROD_SIZE_CD, PROD_COUNT, PROD_PRICE, SORT"
				+ ")"
				+ "VALUES (?,?,?,?,?,?,?)")
		.setParameter(1, cartDetailDto.getCartCd())
		.setParameter(2, cartDetailDto.getProdCd())
		.setParameter(3, cartDetailDto.getProdColorCd())
		.setParameter(4, cartDetailDto.getProdSizeCd())
		.setParameter(5, cartDetailDto.getProdCount())
		.setParameter(6, cartDetailDto.getProdPrice())
		.setParameter(7, cartDetailDto.getSort())
		.executeUpdate();
	}
	


	
}
