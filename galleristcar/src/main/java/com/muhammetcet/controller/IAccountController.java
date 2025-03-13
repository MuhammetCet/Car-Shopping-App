package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoAccount;
import com.muhammetcet.dto.DtoAccountIU;

public interface IAccountController {

	RootEntity<DtoAccount> saveAccount(DtoAccountIU doAccountIU);
	
}
