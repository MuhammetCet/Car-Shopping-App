package com.muhammetcet.jwt;

import java.security.Key;
import java.util.Base64.Decoder;
import java.util.Currency;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	 
	
	public static final String  SECRET_KEY="AqE7xTzf7DtHZ+g9KAANUStncWkCWFKz8qu+g6t/9io=";
	
	
	public String generateToken(UserDetails userDetails) {//token oluştu
		
		return Jwts.builder()
		.setSubject(userDetails.getUsername())
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)) // 2 saat geçerli
		.signWith(getKey(),SignatureAlgorithm.HS256).compact();
				
				
	}
	public String getUsernameByToken(String token) {
		
	return	exportToken(token, Claims::getSubject);
	}
	
public boolean isTokenExpired(String token) {
Date expireDate=exportToken(token, Claims::getExpiration);

return expireDate.before(expireDate);
	
}
	
	
	
	
	
	public Claims getClaims(String token) {//token çözüldü
		 Claims claim = Jwts.parserBuilder().setSigningKey(getKey())
		 .build().parseClaimsJws(token).getBody();
		
		return claim;
	}
	
	public <T>T exportToken (String token,Function<Claims, T> claimFunction){//token tamamne çözüldü dönüştürüldü
		
		Claims claims = getClaims(token);
	return	claimFunction.apply(claims);
	}
	public Key getKey() {
		
		byte[] key = Decoders.BASE64.decode(SECRET_KEY);
		
return	Keys.hmacShaKeyFor(key);
		
	}
	
	

}
