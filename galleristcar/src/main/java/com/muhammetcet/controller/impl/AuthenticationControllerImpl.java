package com.muhammetcet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.muhammetcet.controller.IAuthenticationController;
import com.muhammetcet.controller.RestBaseController;
import com.muhammetcet.controller.RootEntity;
import com.muhammetcet.dto.AuthRequest;
import com.muhammetcet.dto.AuthResponse;
import com.muhammetcet.dto.DtoUser;
import com.muhammetcet.dto.RefreshTokenRequest;
import com.muhammetcet.service.impl.AuthenticationServiceImpl;

import jakarta.validation.Valid;

@RestController
public class AuthenticationControllerImpl  extends RestBaseController implements IAuthenticationController{
@Autowired
	private AuthenticationServiceImpl authenticationServiceImpl;
	
	
	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register( @Valid  @RequestBody AuthRequest input) {
	return	ok(authenticationServiceImpl.register(input));
	}

@PostMapping("/authenticate")
	@Override
	public RootEntity<AuthResponse> authenticate(@Valid @RequestBody   AuthRequest input) {
		return ok(authenticationServiceImpl.authenticate(input));
	}
@PostMapping("/refreshToken")
@Override
public RootEntity<AuthResponse> refreshToken( @Valid @RequestBody   RefreshTokenRequest input) {
return ok(authenticationServiceImpl.refreshToken(input));
}

	
}
