package com.muhammetcet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhammetcet.model.Adress;

@Repository
public interface AddressRepository  extends JpaRepository<Adress, Long>{

	
	
	
}
