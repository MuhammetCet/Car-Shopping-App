package com.muhammetcet.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.muhammetcet.dto.AuthRequest;
import com.muhammetcet.dto.AuthResponse;
import com.muhammetcet.dto.DtoUser;
import com.muhammetcet.dto.RefreshTokenRequest;
import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.jwt.JWTService;
import com.muhammetcet.model.RefreshToken;
import com.muhammetcet.model.User;
import com.muhammetcet.repository.RefreshTokenRepository;
import com.muhammetcet.repository.UserRepository;
import com.muhammetcet.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private JWTService jwtService;
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Override
	public DtoUser register(AuthRequest input) {
		DtoUser dtoUser = new DtoUser();

		User user = createUser(input);
		userRepository.save(user);
		BeanUtils.copyProperties(user, dtoUser);
		return dtoUser;

	}

	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setCreateTime(new Date());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setUser(user);
		return refreshToken;
	}

	public User createUser(AuthRequest input) {
		if (input.getPassword() == null || input.getPassword().isEmpty()) {
			throw new IllegalArgumentException("Şifre bulunamadı veya hatalı ");
		}

		User user = new User();
		user.setCreateTime(new Date());
		user.setUserName(input.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(input.getPassword()));
		return user;
	}
	public boolean refreshTokenIsExpired(Date expiredDate) {
		
		return new Date().before(expiredDate);
	}

	@Override
	public AuthResponse authenticate(AuthRequest input) {

		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					input.getUsername(), input.getPassword());

			authenticationProvider.authenticate(authenticationToken);
			Optional<User> optUser = userRepository.findByUserName(input.getUsername());
			String accessToken = jwtService.generateToken(optUser.get());
			RefreshToken refreshToken = createRefreshToken(optUser.get());
			RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);
			
			return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
		}

	}

	@Override
	public AuthResponse refreshToken(RefreshTokenRequest input) {
Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());

if (optRefreshToken.isEmpty()) {
	
	throw new BaseException(new ErrorMessage(MessageType.REFRESHTOKEN_NOT_VALID,input.getRefreshToken()));
	
}

if (!refreshTokenIsExpired(optRefreshToken.get().getExpiredDate())) {
	 
	throw new BaseException(new ErrorMessage(MessageType.IS_TOKEN_EXPIRED,input.getRefreshToken()));
	
	
}
           User user = optRefreshToken.get().getUser();
           
           String accessToken = jwtService.generateToken(user);
           
           
      RefreshToken refreshToken = createRefreshToken(user);     
      
      RefreshToken saveRefreshToken = refreshTokenRepository.save(refreshToken);



return new AuthResponse( accessToken,saveRefreshToken.getRefreshToken());
	}

	

	
}
