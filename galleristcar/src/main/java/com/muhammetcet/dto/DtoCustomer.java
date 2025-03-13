	package com.muhammetcet.dto;
	
	import java.util.Date;
	
	import com.muhammetcet.model.Account;
	import com.muhammetcet.model.Adress;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.OneToOne;
	import lombok.Getter;
	import lombok.Setter;
	
	@Getter
	@Setter
	public class DtoCustomer extends DtoBase {
		    private String firstName;
		    private String lastName;
		    private String tckn;
		    private Date birthOfDate;
		    private DtoAddress adress;  // adressId'yi adress olarak değiştirdim
		    private DtoAccount account;
	
	}
