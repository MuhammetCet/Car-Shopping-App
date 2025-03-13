package com.muhammetcet.model;

import java.math.BigDecimal;
import java.util.Date;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "refresh_token")
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity {
	@Column(name = "refresh_token")
	private String refreshToken;
	@Column(name = "expired_date")
	private Date expiredDate;
	@ManyToOne
	private User user;

}
