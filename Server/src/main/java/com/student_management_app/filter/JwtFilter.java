package com.student_management_app.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student_management_app.service.JwtService;
import com.student_management_app.utility.JWTutility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTutility jwtUtility;

    @Autowired
    private JwtService jwtService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
        final String header = request.getHeader("Authorization");
            String jwtToken = null;
            String userName = null;
        if (header != null && header.startsWith("Bearer ")) {

            jwtToken = header.substring(7);

            try {
                userName = jwtUtility.getUsernameFromToken(jwtToken);

            } catch (IllegalArgumentException ex) {
                System.out.println("Unable to get jwt token.");
            } catch (ExpiredJwtException e) {
                System.out.println("Jwt token is expired.");
            }
        } else {
            System.out.println("Jwt Token does not start with Bearer!");
        }
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = jwtService.loadUserByUsername(userName);

            if(jwtUtility.validateToken(jwtToken, userDetails)) {

               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
               new UsernamePasswordAuthenticationToken(userDetails, null, 
                                userDetails.getAuthorities());
                
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
    
            filterChain.doFilter(request, response);
    }
}
