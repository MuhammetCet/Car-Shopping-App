package com.muhammetcet.dto;

import java.math.BigDecimal;

import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAccount extends DtoBase{
	
	private String accountNo;
	
	private String iban;
	
	private BigDecimal amount;
	
	private CurrencyType currencyType;
	


}
