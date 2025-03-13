package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoCustomer;
import com.muhammetcet.dto.DtoCustomerIU;

public interface ICustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
	
	
}
