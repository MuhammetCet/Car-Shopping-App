package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.IAdressController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoAddressIU;
import com.muhammetcet.service.IAddressService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("rest/api/adress")
public class AdressControllerImpl  extends RestBaseController implements IAdressController{
	@Autowired
	private IAddressService adresService;
	
	
@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAdress(@Valid @RequestBody   DtoAddressIU input) {
		return ok(adresService.saveAddress(input));
	}

	
	
}
