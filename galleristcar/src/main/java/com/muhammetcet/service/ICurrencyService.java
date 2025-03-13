package com.muhammetcet.service;

import com.muhammetcet.dto.CurrencyResponse;

public interface ICurrencyService {
	
	public CurrencyResponse getCurrencyResponse(String startDate,String endDate);

}
