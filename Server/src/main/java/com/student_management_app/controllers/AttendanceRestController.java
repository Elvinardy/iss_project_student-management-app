package com.student_management_app.controllers;

import com.student_management_app.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceRestController {
    
    @Autowired
    private AttendanceService attSvc;

    public AttendanceRestController(AttendanceService attSvc) {
        this.attSvc = attSvc;
    }
    
  /*   @PostMapping
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance, Student student) {
        Attendance newAttendance = attSvc.addAttendance(attendance, student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    } */

} 
 