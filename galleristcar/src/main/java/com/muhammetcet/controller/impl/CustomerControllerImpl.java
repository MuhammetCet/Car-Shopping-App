package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.ICustomerController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoCustomer;
import com.muhammetcet.dto.DtoCustomerIU;
import com.muhammetcet.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl extends RestBaseController implements ICustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoCustomer>  saveCustomer( @RequestBody  @Valid DtoCustomerIU dtoCustomerIU) {
		  System.out.println("Received DTO: " + dtoCustomerIU);
		return ok(customerService.saveCustomer(dtoCustomerIU));
	}

}
