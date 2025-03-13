package com.muhammetcet.service.impl;

import java.security.AlgorithmParameterGenerator;
import java.util.Date;
import java.util.Optional;

import org.apache.el.lang.VariableMapperFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoAddress;
import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoGalleristCar;
import com.muhammetcet.dto.DtoGalleristCarIU;
import com.muhammetcet.dto.DtoGalleristIU;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.model.Car;
import com.muhammetcet.model.Gallerist;
import com.muhammetcet.model.GalleristCar;
import com.muhammetcet.repository.CarRepository;
import com.muhammetcet.repository.GalleristCarRepository;
import com.muhammetcet.repository.GalleristRepository;
import com.muhammetcet.service.IGalleristCarService;

@Service
public class GalleristCarService implements IGalleristCarService {

	@Autowired
	private GalleristRepository galleristRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private GalleristCarRepository galleristCarRepository;

	public GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

		GalleristCar galleristCar = new GalleristCar();
		galleristCar.setCreateTime(new Date());

		Optional<Gallerist> galleristOpt = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		Optional<Car> carOpt = carRepository.findById(dtoGalleristCarIU.getCarId());
		if (galleristOpt.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getGalleristId().toString()));

		}
		if (carOpt.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getCarId().toString()));
		}

		galleristCar.setGallerist(galleristOpt.get());
		galleristCar.setCar(carOpt.get());

		return galleristCar;

	}
@Override
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		
		DtoGalleristCar dtoGalleristCar=new DtoGalleristCar();
		DtoCar dtoCar=new DtoCar();
		DtoGallerist dtoGallerist=new DtoGallerist();
		DtoAddress dtoAddress=new DtoAddress();
		
		
	GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
	BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAdress(), dtoAddress);
		dtoGallerist.setAdress(dtoAddress);
		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);
		return dtoGalleristCar;
	}

	

}
