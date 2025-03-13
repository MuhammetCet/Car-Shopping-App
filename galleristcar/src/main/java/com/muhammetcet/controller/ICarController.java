package com.muhammetcet.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoCarIU;

import jakarta.validation.Valid;

public interface ICarController {

	RootEntity<DtoCar>saveCar( DtoCarIU dtoCarIU);
	
}
