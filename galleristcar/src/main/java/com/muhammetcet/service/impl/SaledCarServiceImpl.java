package com.muhammetcet.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammetcet.dto.CurrencyResponse;
import com.muhammetcet.dto.DtoCar;
import com.muhammetcet.dto.DtoCustomer;
import com.muhammetcet.dto.DtoGallerist;
import com.muhammetcet.dto.DtoSaledCar;
import com.muhammetcet.dto.DtoSaledCarIU;
import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.model.Car;
import com.muhammetcet.model.Customer;
import com.muhammetcet.model.Gallerist;
import com.muhammetcet.model.SaledCar;
import com.muhammetcet.repository.CarRepository;
import com.muhammetcet.repository.CustomerRepository;
import com.muhammetcet.repository.GalleristCarRepository;
import com.muhammetcet.repository.GalleristRepository;
import com.muhammetcet.repository.SaledCarRepository;
import com.muhammetcet.service.ICurrencyService;
import com.muhammetcet.service.ISaledCarService;
import com.muhammetcet.utils.DateUtils;

@Service
public class SaledCarServiceImpl implements ISaledCarService {
	@Autowired
	private SaledCarRepository saledCarRepository;
	@Autowired
	private GalleristRepository galleristRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private GalleristCarRepository galleristCarRepository;

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ICurrencyService currencyService;

	public BigDecimal convertCustomerAmountToUSD(Customer customer) {

		CurrencyResponse currencyResponse = currencyService.getCurrencyResponse(DateUtils.getCurrentDate(new Date()),
				DateUtils.getCurrentDate(new Date()));

		BigDecimal usd = new BigDecimal(currencyResponse.getItems().get(0).getUsd());
		BigDecimal divideUsd = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);

		return divideUsd;
	}
	
	public BigDecimal remainingCustomerAmounth(Customer customer,Car car) {
		BigDecimal customerUSDAmounth = convertCustomerAmountToUSD(customer);
		BigDecimal remainingCustomerMoney = customerUSDAmounth.subtract(car.getPrice());
		CurrencyResponse currencyResponse = currencyService.getCurrencyResponse(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
BigDecimal usd = new BigDecimal(currencyResponse.getItems().get(0).getUsd());
		
		
		return remainingCustomerMoney.multiply(usd);
	}
	

	public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {

		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
		if (optCustomer.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCustomerId().toString()));
		}
		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		if (optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
		}

		BigDecimal convertCustomerAmountToUSD = convertCustomerAmountToUSD(optCustomer.get());

		if (convertCustomerAmountToUSD.compareTo(optCar.get().getPrice()) == 0
				|| convertCustomerAmountToUSD.compareTo(optCar.get().getPrice()) > 0) {

			return true;

		}
		return false;

	}

	public boolean checkCarStatus(Long carId) {
		Optional<Car> optCar = carRepository.findById(carId);

		if (optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {

			return false;
		}

		return true;
	}

	private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
		SaledCar saledCar = new SaledCar();
		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));

		return saledCar;
	}

	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {

		if (!checkAmount(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
		}

		if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException(
					new ErrorMessage(MessageType.CAR_IS_ALREADY_SALED, dtoSaledCarIU.getCarId().toString()));
		}

		SaledCar saledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
		Car car = saledCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);
		carRepository.save(car);
		
Customer customer = saledCar.getCustomer();

customer.getAccount().setAmount(remainingCustomerAmounth(customer, car));
customerRepository.save(customer);
		return toDto(saledCar);
	}
	public DtoSaledCar toDto(SaledCar saledCar) {
		DtoCustomer dtoCustomer=new DtoCustomer();
		DtoCar dtoCar=new DtoCar();
		DtoGallerist dtoGallerist=new DtoGallerist();
		DtoSaledCar dtoSaledCar=new DtoSaledCar();
		
		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getGallerist(), dtoGallerist);
		
		dtoSaledCar.setCar(dtoCar);
dtoSaledCar.setCustomer(dtoCustomer);
dtoSaledCar.setGallerist(dtoGallerist);

return dtoSaledCar;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
