package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.ISaledCarController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoSaledCar;
import com.muhammetcet.dto.DtoSaledCarIU;
import com.muhammetcet.service.ISaledCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saledcar")
public class SaledCarControllerImpl extends RestBaseController implements ISaledCarController {

	@Autowired
	private ISaledCarService saledCarService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {

return ok(saledCarService.buyCar(dtoSaledCarIU)); 


	}

}
