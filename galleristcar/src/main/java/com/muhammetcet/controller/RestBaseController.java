package com.muhammetcet.controller;

import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

public class RestBaseController {

	public <T> RootEntity<T> ok(T paylod) {
		return RootEntity.Ok(paylod);

	}

	public <T> RootEntity<T> error(String errorMessage) {
		return RootEntity.error(errorMessage);

	}

}
