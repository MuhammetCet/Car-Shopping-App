package com.muhammetcet.config;

import java.nio.channels.NonReadableChannelException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;
import com.muhammetcet.model.User;
import com.muhammetcet.repository.UserRepository;

@Configuration
public class AppConfig {
	@Autowired
	private UserRepository userRepository;

	@Bean
	public UserDetailsService userDetailsService() {

		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			 Optional<User> optional = userRepository.findByUserName(username);
			 
			 if (optional.isEmpty()) {
				throw new BaseException(new ErrorMessage(MessageType.NOT_FOUND_USERNAME,username));
			}
			 return optional.get();

			}
		};
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(bcryptPasswordEncoder());
		return provider;
	}
	
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
