package com.muhammetcet.model;

import java.math.BigDecimal;
import java.util.Optional;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "galleristcar",uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id"},name = "uq_gallerist_car ")} )
@NoArgsConstructor
@AllArgsConstructor
public class GalleristCar extends BaseEntity {
	
	@ManyToOne
	private Gallerist gallerist;
	@ManyToOne
	private Car car;

}
