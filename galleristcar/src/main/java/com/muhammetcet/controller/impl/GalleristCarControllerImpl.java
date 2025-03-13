package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.IGalleristCarController;
import com.muhammetcet.controller.IGalleristController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoGalleristCar;
import com.muhammetcet.dto.DtoGalleristCarIU;
import com.muhammetcet.service.IGalleristCarService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/rest/api/galleristcar")
public class GalleristCarControllerImpl extends RestBaseController implements IGalleristCarController {
@Autowired
	private IGalleristCarService galleristCarService;
@PostMapping("/save")
@Override
public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody  DtoGalleristCarIU dtoGalleristCarIU) {
	
return	ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));

}


	
	
}
