package com.backend.v1.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.v1.data.entity.cart.CartMasterEntity;

public interface CartRepository extends JpaRepository<CartMasterEntity, String>, CartCustomReposiroty{


}
