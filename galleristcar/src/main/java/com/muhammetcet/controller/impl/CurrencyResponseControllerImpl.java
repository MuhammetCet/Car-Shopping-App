package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.ICurrencyResponseController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.CurrencyResponse;
import com.muhammetcet.service.ICurrencyService;
@RestController
@RequestMapping("/rest/api/")
public class CurrencyResponseControllerImpl extends RestBaseController  implements ICurrencyResponseController {
@Autowired
private	ICurrencyService  currencyService;
	
	@GetMapping("/currency")
	@Override
	public RootEntity<CurrencyResponse> getCurrencyResponse(  @RequestParam("startDate") String startDate,@RequestParam("endDate")  String endDate) {
		
		
return ok(currencyService.getCurrencyResponse(startDate, endDate));
}

	
	
}
