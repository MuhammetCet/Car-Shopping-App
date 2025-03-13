package com.muhammetcet.exception;

import lombok.Getter;

@Getter

public enum MessageType {

	NO_RECORD_EXIST("1004", "Kayıt Bulunamadı"), GENERAL_EXCEPTİON("9999", "Genel Bir Hata Oluştu"),IS_TOKEN_EXPIRED("1005","Token süresi doldu"),USERNAME_OR_PASSWORD_INVALID("1009","Kullanıcı adı veya şifre hatalı")
	,NOT_FOUND_USERNAME("1008","Username bulunamadı"),REFRESHTOKEN_NOT_VALID("1003","Böyle bir token bulunamadı"),NOT_FOUND_CURRENCY("1020","Döviz Kuru Alınamadı")
	,CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1050","Müşterinin parası yetersizdir"),
	CAR_IS_ALREADY_SALED("1030","Araba zaten satılmış durumdadır");

	private String code;

	private String message;

	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;

	}

}
