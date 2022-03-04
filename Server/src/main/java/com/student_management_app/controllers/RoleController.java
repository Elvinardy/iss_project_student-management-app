package com.student_management_app.controllers;

import com.student_management_app.model.Role;
import com.student_management_app.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    
    @Autowired
    private RoleService roleSvc;

    @PostMapping(path="/createRole")
    public Role createNewRole(@RequestBody Role role) { 
        return roleSvc.createNewRole(role);
    }
}
