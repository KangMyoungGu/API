package com.backend.v1.repository.product.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.backend.v1.data.dto.product.OuterDto;
import com.backend.v1.data.entity.product.OuterEntity;
import com.backend.v1.data.entity.product.QOuterEntity;
import com.backend.v1.repository.product.ProductRepository;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private @PersistenceContext EntityManager entityManager;
	
	@Override
	public void findBestItemList() {
	}

	@Override
	public List<OuterEntity> findProductItemList(String prodCode) {
		JPAQuery query = new JPAQuery(entityManager);
		QOuterEntity entity = new QOuterEntity("camp");
		
		return query.from(entity).where(entity.commonCode.eq(prodCode)).list(entity);
	}

}
