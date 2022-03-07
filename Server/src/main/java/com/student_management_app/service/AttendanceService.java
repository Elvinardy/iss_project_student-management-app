package com.student_management_app.service;

import com.student_management_app.model.Attendance;
import com.student_management_app.model.Student;
import com.student_management_app.repository.AttendanceRepository;
import com.student_management_app.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttendanceService {
    
    @Autowired
    private AttendanceRepository attRepo;

    @Autowired
    private StudentRepository studentRepo;
  /*   public Optional<Integer> addAttendance(Attendance attendance, Student student) {

        attRepo.insertAttendance(attendance, student);
        return Optional.empty();
    } */
    public Attendance insertAttendance(Attendance attendance, Student student) {
        student.getId();
        return attRepo.save(attendance);
    } 
     

    }

    


