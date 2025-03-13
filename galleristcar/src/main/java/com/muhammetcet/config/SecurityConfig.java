package com.muhammetcet.config;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.muhammetcet.handler.AuthEntryPoint;
import com.muhammetcet.jwt.JWTAuthenticationFilter;

@EnableWebMvcSecurity
@Configuration
public class SecurityConfig {

	public final String REGISTER = "/register";

	public final String AUTHENTİCATE = "/authenticate";

	public final String REFRESH_TOKEN = "/refreshToken";
	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private JWTAuthenticationFilter authenticationFilter;
	@Autowired
	private AuthEntryPoint authEntryPoint;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeHttpRequests(request -> request
				.requestMatchers(REGISTER, AUTHENTİCATE, REFRESH_TOKEN, "/register", "/authenticate", "/refreshToken")
				.permitAll().anyRequest().authenticated()).exceptionHandling().authenticationEntryPoint(authEntryPoint)
				.and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
}
