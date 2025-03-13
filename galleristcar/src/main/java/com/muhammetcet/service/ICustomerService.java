package com.muhammetcet.service;

import com.muhammetcet.dto.DtoCustomer;
import com.muhammetcet.dto.DtoCustomerIU;

public interface ICustomerService {
	
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
