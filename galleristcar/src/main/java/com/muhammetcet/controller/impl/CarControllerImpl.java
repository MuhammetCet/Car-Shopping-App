package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.ICarController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoCarIU;
import com.muhammetcet.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class CarControllerImpl  extends RestBaseController implements ICarController{
	@Autowired
	private ICarService carService;
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
	    System.out.println("ÇALIŞTI - Gelen JSON: " + dtoCarIU);

	    if (dtoCarIU == null) {
	        throw new RuntimeException("Request body null geldi!");
	    }
	    
	    return ok(carService.saveCar(dtoCarIU));
	}


	
	
	
}
