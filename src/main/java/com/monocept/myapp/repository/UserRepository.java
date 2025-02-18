package com.monocept.myapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.myapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailOrMobile(String email, long mobile);

}
