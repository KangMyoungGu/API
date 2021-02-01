package com.backend.v1.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.v1.data.entity.order.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, String> {

	List<OrderDetailEntity> findAllByOrderCodeIn(List<String> orderCodeList);

}
