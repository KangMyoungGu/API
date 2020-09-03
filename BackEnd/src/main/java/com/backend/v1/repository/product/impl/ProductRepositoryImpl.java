package com.backend.v1.repository.product.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.backend.v1.common.util.DBUtil;
import com.backend.v1.data.dto.product.ProdColorDto;
import com.backend.v1.data.dto.product.ProdSizeDto;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.ProdInfoEntity;
import com.backend.v1.data.entity.product.QBestEntity;
import com.backend.v1.data.entity.product.QProdEntity;
import com.backend.v1.data.entity.product.QProdInfoEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.mysema.query.jpa.impl.JPAQuery;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private @PersistenceContext EntityManager entityManager;
	private @Autowired @Qualifier("sqlSession") SqlSession sqlSession;
	
	@Override
	public List<ProdEntity> findProductBestItemList() {
		JPAQuery query = new JPAQuery(entityManager);
		QProdEntity entity = new QProdEntity("prod");
		QBestEntity bestEntity = new QBestEntity("best");
	
		List<ProdEntity> list = query.from(entity)
								.innerJoin(bestEntity)
								.on(entity.prodCode.eq(bestEntity.prodCode))
								.list(entity);
		return list;

	}


	@Override
	public List<ProdEntity> findProductItemList(String prodCode) {
		JPAQuery query = new JPAQuery(entityManager);

		QProdEntity entity = new QProdEntity("prod");
		
		List<ProdEntity> list = query.from(entity)
								.where(entity.commonCode.eq(prodCode))
								.where(entity.useYn.eq("Y"))
								.list(entity);
		
		return list;
	}

	@Override
	public ProdEntity findProductInfo(String prodCode) {
		JPAQuery query = new JPAQuery(entityManager);

		QProdEntity entity = new QProdEntity("prod");

		ProdEntity data = query.from(entity)
						.where(entity.prodCode.eq(prodCode))
						.singleResult(entity);
		
		return data;
	}

	@Override
	public List<ProdInfoEntity> findProductDetailImage(String prodCode) {
		JPAQuery query = new JPAQuery(entityManager);
		
		QProdInfoEntity entity = new QProdInfoEntity("prodInfo");
		
		List<ProdInfoEntity> list = query.from(entity)
									.where(entity.prodCode.eq(prodCode))
									.where(entity.useYn.eq("Y"))
									.orderBy(entity.sortSeq.asc())
									.list(entity);
		
		return list;
	}


	@Override
	public List<ProdColorDto> findProductColorInfo(String prodCode) {
		return sqlSession.selectList(DBUtil.statement(ProductRepository.class, "findProductColorInfo"),prodCode);
	}


	@Override
	public List<ProdSizeDto> findProductSizeInfo(String prodCode) {
		return sqlSession.selectList(DBUtil.statement(ProductRepository.class, "findProductSizeInfo"),prodCode);
	}


}
