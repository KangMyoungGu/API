package com.backend.v1.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.v1.data.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>, UserCustomRepository{
	Optional<UserEntity> findByUserId(String userId);

	Optional<UserEntity> findByUserCode(String userCode);
}
