package com.backend.v1.repository.product.impl;

import java.util.List;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.entity.product.ProdEntity;
import com.backend.v1.data.entity.product.QBestEntity;
import com.backend.v1.data.entity.product.QProdEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import com.mysema.query.types.Projections;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private @PersistenceContext EntityManager entityManager;
	
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




}
