package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.IAccountController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity; 
import com.muhammetcet.dto.DtoAccount;
import com.muhammetcet.dto.DtoAccountIU;
import com.muhammetcet.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class AccountControllerImpl extends RestBaseController implements IAccountController {
	@Autowired
	private IAccountService accountService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU doAccountIU) {
return ok(accountService.saveAccount(doAccountIU));
	}

}
