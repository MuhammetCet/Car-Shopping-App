package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoAddressIU;

public interface IAdressController {

public	RootEntity<DtoAddress>saveAdress(DtoAddressIU input);
	
}
