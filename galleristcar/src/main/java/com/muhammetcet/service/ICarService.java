package com.muhammetcet.service;

import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoCarIU;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU dtoCarIU);
	
}
