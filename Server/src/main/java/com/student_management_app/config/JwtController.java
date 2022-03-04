package com.student_management_app.config;

import com.student_management_app.model.JwtRequest;
import com.student_management_app.model.JwtResponse;
import com.student_management_app.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    
    @Autowired
    private JwtService jwtService;

    @PostMapping(path="/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        return jwtService.createJwtToken(jwtRequest);
    }

}
