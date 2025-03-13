package com.muhammetcet.model;

import java.math.BigDecimal;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
	@Column(name = "plaka")
	private String plaka;
	
	@Column(name = "brand")
	private String brand;
	                               //ENUM OLANLARI MUTLAKA ENUMERATED OLARAK İŞARETLEYECEKSİN
	@Column(name = "model")
	private String model;
	
	@Column(name = "production_year")
	private Integer productionYear;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "currencyType")
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	@Column(name = "damage_price")
	private BigDecimal damagePrice;
	
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;

}
