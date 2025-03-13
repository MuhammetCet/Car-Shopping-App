package com.muhammetcet.controller;

import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoGalleristIU;

public interface IGalleristController {

	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
	
}
