package com.muhammetcet.service;

import com.muhammetcet.dto.AuthRequest;
import com.muhammetcet.dto.AuthResponse;
import com.muhammetcet.dto.DtoUser;
import com.muhammetcet.dto.RefreshTokenRequest;
import com.muhammetcet.model.RefreshToken;

public interface IAuthenticationService {

	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest refreshToken);
	
}
