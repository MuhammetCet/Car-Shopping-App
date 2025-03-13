package com.muhammetcet.service;

import com.muhammetcet.dto.DtoAccount;
import com.muhammetcet.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU input);	

	
}
