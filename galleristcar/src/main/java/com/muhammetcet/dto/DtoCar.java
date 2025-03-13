package com.muhammetcet.dto;

import java.math.BigDecimal;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCar extends DtoBase{

	private String plaka;
	
	private String brand;
	                               //ENUM OLANLARI MUTLAKA ENUMERATED OLARAK İŞARETLEYECEKSİN
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	private BigDecimal damagePrice;
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;
	
}
