package com.muhammetcet.controller;

import com.muhammetcet.dto.CurrencyResponse;

public interface ICurrencyResponseController {

	public RootEntity<CurrencyResponse> getCurrencyResponse(String startDate,String endDate);
	
}
