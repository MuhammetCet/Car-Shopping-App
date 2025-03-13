package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoSaledCar;
import com.muhammetcet.dto.DtoSaledCarIU;
import com.muhammetcet.model.SaledCar;

public interface ISaledCarController {
RootEntity<DtoSaledCar>buyCar(DtoSaledCarIU dtoSaledCarIU);
}
