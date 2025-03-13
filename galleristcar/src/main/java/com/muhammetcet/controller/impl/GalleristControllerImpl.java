package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.IGalleristController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoGalleristIU;
import com.muhammetcet.service.IGalleristService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist")
public class GalleristControllerImpl extends RestBaseController implements IGalleristController {
	@Autowired
	private IGalleristService galleristService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody  DtoGalleristIU dtoGalleristIU) {
return ok(galleristService.saveGallerist(dtoGalleristIU));
	}

}

