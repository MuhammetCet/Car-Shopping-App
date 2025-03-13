package com.muhammetcet.dto;

import com.muhammetcet.model.Gallerist;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoGalleristCarIU {
	@NotNull
	private Long galleristId;

	@NotNull
	private Long carId;

	
}
