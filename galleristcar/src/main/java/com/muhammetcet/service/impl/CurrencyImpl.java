package com.muhammetcet.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.muhammetcet.dto.CurrencyResponse;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.service.ICurrencyService;

@Service
public class CurrencyImpl implements ICurrencyService {

	@Override
	public CurrencyResponse getCurrencyResponse(String startDate, String endDate) {
		// https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A.YTL&startDate=11-03-2025&endDate=11-03-2025&type=json
		String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A.YTL";
		String type = "json";
		String endpoint = rootURL+"series=" +series+"&startDate="+ startDate+"&endDate="+endDate+"&type="
				+type;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key", "KqZz4xNNu0");

		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		try {

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CurrencyResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
					new ParameterizedTypeReference<CurrencyResponse>() {
					});
			if (response.getStatusCode().is2xxSuccessful()) {
			return	response.getBody();
			}

		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.NOT_FOUND_CURRENCY, e.getMessage()));
		}

		return null;
	}
}

