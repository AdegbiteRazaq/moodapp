package com.school.sport_enrollment.Utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    // @Lazy
    // @Autowired
    // private UserDetailsService userDetailsService;


    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil; // Assuming you have a JwtUtil for token operations

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        // Check if the Authorization header is present and starts with Bearer
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            System.out.println(username);
        }

        // If the JWT is valid, set the authentication context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            CustomUserDetailImpl userDetails = (CustomUserDetailImpl) customUserDetailService.loadUserByUsername(username);
            System.out.println("this is userdetail" + userDetails.getEmail());

            // Validate the token and set authentication
            if (jwtUtil.validateToken(jwt, userDetails.getEmail())) {
                System.out.println("hereee");
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } 
        } 

        // Proceed with the filter chain for valid requests
        chain.doFilter(request, response);
    }
}