package com.backend.v1.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.v1.data.entity.order.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, String> {

}
