package com.backend.v1.repository.order.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backend.v1.data.entity.order.QOrderEntity;
import com.backend.v1.repository.order.OrderCustomRepository;
import com.mysema.query.jpa.impl.JPAQuery;

public class OrderCustomRepositoryImpl implements OrderCustomRepository {
	
	private @PersistenceContext EntityManager entityManager;
	
	@Override
	public List<String> findAllOrderCodeByUserCode(String userCode) {
		JPAQuery query = new JPAQuery(entityManager);
		QOrderEntity entity = QOrderEntity.orderEntity;
		
		List<String> list = query.from(entity)
				.where(entity.userCode.eq(userCode))
				.listResults(entity.orderCode)
				.getResults();
		
		return list;
	}
}
