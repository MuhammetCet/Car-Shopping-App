package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoGalleristCar;
import com.muhammetcet.dto.DtoGalleristCarIU;

public interface IGalleristCarController {
public RootEntity<DtoGalleristCar>  saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
