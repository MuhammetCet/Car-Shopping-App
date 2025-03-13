package com.muhammetcet.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoCarIU;
import com.muhammetcet.model.Car;
import com.muhammetcet.repository.CarRepository;
import com.muhammetcet.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {
	@Autowired
	private CarRepository carRepository;

	public Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreateTime(new Date());
		// BURADA EXTRA KOPYALAMA İŞLEMİ YAPMADIK ÇÜNKÜ DİĞER
		// SINIFLARDAN HERHANGİ BİR NESNE TUTMUYOR

		BeanUtils.copyProperties(dtoCarIU, car);

		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		
		DtoCar dtoCar=new DtoCar();
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
	}

}
