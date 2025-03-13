package com.muhammetcet.model;

import java.lang.invoke.StringConcatFactory;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Adress extends BaseEntity{
@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "neighborhood")
	private String neighborhood;
	@Column(name = "street")
	private String street;
	
	
	
}
