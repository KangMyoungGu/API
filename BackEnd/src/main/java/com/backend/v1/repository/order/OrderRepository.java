package com.backend.v1.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.v1.data.entity.order.OrderDetailEntity;
import com.backend.v1.data.entity.order.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, String>, OrderCustomRepository {
	List<String> findAllOrderCodeByUserCode(String userCode);
}
