package com.muhammetcet.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoGalleristIU;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.model.Adress;
import com.muhammetcet.model.Gallerist;
import com.muhammetcet.repository.AddressRepository;
import com.muhammetcet.repository.GalleristRepository;
import com.muhammetcet.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService {
	@Autowired
	private GalleristRepository galleristRepository;
	@Autowired
	private AddressRepository addressRepository;

	public Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

		Optional<Adress> optAdress = addressRepository.findById(dtoGalleristIU.getAdressId());
		if (optAdress.isEmpty()) {

			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAdressId().toString()));

		}

		Gallerist gallerist = new Gallerist();
		gallerist.setAdress(optAdress.get());
		gallerist.setCreateTime(new Date());

		BeanUtils.copyProperties(dtoGalleristIU, gallerist);

		return gallerist;

	}

	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {	
		DtoGallerist dtoGallerist=new DtoGallerist();
		DtoAddress dtoAddress=new DtoAddress();
		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		BeanUtils.copyProperties(savedGallerist.getAdress(), dtoAddress);
		
		dtoGallerist.setAdress(dtoAddress);
		
		return dtoGallerist;
	}

}
