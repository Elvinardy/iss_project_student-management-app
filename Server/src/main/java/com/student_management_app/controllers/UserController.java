package com.student_management_app.controllers;

import com.student_management_app.model.JwtRequest;
import com.student_management_app.model.JwtResponse;
import com.student_management_app.service.UserService;
import com.student_management_app.utility.JWTutility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    
    private JWTutility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "Welcome, You're In!";

    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        
        try {
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(),
                        jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = 
                jwtUtility.generateToken(userDetails);
        
        return new JwtResponse(token);
                
    }
    
}
