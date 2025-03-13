package com.muhammetcet.service;

import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoAddressIU;

public interface IAddressService {
	
public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
