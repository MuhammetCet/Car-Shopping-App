package com.muhammetcet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhammetcet.model.User;
import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	
	
	public Optional<User> findByUserName(String username);
	
	
}
