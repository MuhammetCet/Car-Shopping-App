package com.muhammetcet.service;

import com.muhammetcet.dto.DtoSaledCar;
import com.muhammetcet.dto.DtoSaledCarIU;

public interface ISaledCarService {
	
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
