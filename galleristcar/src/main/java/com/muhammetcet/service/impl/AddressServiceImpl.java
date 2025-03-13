package com.muhammetcet.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.muhammetcet.model.Adress;


import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoAddressIU;
import com.muhammetcet.model.Adress;
import com.muhammetcet.repository.AddressRepository;
import com.muhammetcet.service.IAddressService;

import jakarta.websocket.server.ServerEndpoint;
@Service
public class AddressServiceImpl  implements IAddressService{
	
	@Autowired
private 	AddressRepository addressRepository;
 
	
	public Adress createAddress(DtoAddressIU dtoAddressIU) {
		
	Adress address=new Adress();
	address.setCreateTime(new Date());
		
		
		DtoAddress dtoAddress=new DtoAddress();
		BeanUtils.copyProperties(dtoAddressIU, address);
		
		return address;
	}
	
	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
		DtoAddress dtoAddress= new DtoAddress();
Adress savedAdress = addressRepository.save(createAddress(dtoAddressIU));
		BeanUtils.copyProperties(savedAdress, dtoAddress);
		return dtoAddress; 
	}

	
	
	
}
