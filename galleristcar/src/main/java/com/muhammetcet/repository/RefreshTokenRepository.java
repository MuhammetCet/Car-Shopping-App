package com.muhammetcet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muhammetcet.dto.AuthResponse;
import com.muhammetcet.dto.RefreshTokenRequest;
import com.muhammetcet.model.RefreshToken;
import java.util.List;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByRefreshToken(String input);

}
