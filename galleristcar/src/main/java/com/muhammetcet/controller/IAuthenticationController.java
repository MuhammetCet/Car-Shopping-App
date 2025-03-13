package com.muhammetcet.controller;

import com.muhammetcet.dto.AuthRequest; 
import com.muhammetcet.dto.AuthResponse;
import com.muhammetcet.dto.DtoUser;
import com.muhammetcet.dto.RefreshTokenRequest;

public interface IAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);
	public RootEntity<AuthResponse>authenticate(AuthRequest input);
public RootEntity<AuthResponse>refreshToken(RefreshTokenRequest input);
	
	
}
