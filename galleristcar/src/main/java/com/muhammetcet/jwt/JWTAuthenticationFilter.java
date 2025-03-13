package com.muhammetcet.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.muhammetcet.exception.BaseException;
import com.muhammetcet.exception.ErrorMessage;
import com.muhammetcet.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JWTService jwtService;
    
    @Autowired
    private UserDetailsService userDetailsService; 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        
        try {
            String userName = jwtService.getUsernameByToken(token);
            
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                
                if (userDetails != null && !jwtService.isTokenExpired(token)) {
                    UsernamePasswordAuthenticationToken authenticationToken = 
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (ExpiredJwtException e) {
            throw new BaseException(new ErrorMessage(MessageType.IS_TOKEN_EXPIRED, token));
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTİON, token));
        }

        filterChain.doFilter(request, response);
    }
}
