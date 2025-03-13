package com.muhammetcet.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails{
	@Column(name = "user_name")
	private String userName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "password")
	private String password;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}
	@Override
	public String getPassword() {
	    return this.password;  // Gerçek şifreyi döndürmeli
	}

	@Override
	public String getUsername() {
	    return this.userName;  // Gerçek kullanıcı adını döndürmeli
	}

	
}
