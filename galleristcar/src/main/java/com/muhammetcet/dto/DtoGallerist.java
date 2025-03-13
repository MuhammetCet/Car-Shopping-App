package com.muhammetcet.dto;

import com.muhammetcet.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DtoGallerist extends DtoBase {

	private String firstName;

	private String lastName;

	private DtoAddress adress;

}
