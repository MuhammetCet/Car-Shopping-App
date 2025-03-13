package com.muhammetcet.service;

import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoGalleristIU;

public interface IGalleristService {

	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
	
}
