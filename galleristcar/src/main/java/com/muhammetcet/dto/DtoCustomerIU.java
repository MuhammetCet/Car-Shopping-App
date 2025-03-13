package com.muhammetcet.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muhammetcet.model.Account;
import com.muhammetcet.model.Adress;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	@NotNull
	private String tckn;
	
	@NotNull
	private Date birthOfDate;
	
	@NotNull(message = "BOŞ OLAMAZ")
	private Long adressId;


	@NotNull
	private Long accountId;

	@Override
	public String toString() {
		return "DtoCustomerIU{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", tckn='"
				+ tckn + '\'' + ", birthOfDate=" + birthOfDate + ", adressId=" + adressId + ", accountId=" + accountId
				+ '}';
	}

}
