package com.student_management_app.controllers;

import com.student_management_app.model.Attendance;
import com.student_management_app.model.Student;
import com.student_management_app.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class AttendanceRestController {
    
    @Autowired
    private AttendanceService attSvc;

    public AttendanceRestController(AttendanceService attSvc) {
        this.attSvc = attSvc;
    }
    
    @PostMapping("/attendance")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance, Student student) {
        attSvc.insertAttendance(attendance, student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

} 
 