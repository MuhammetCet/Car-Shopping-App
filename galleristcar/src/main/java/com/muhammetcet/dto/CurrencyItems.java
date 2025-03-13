package com.muhammetcet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyItems {
	@JsonProperty("Tarih")
	private String date;
	@JsonProperty("TP_DK_USD_A_YTL")
	private String usd;

	
	//"Tarih": "11-03-2025",
    //"TP_DK_USD_A_YTL": "36.4558
}
