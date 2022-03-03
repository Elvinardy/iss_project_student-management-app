package com.student_management_app.service;

import java.util.Optional;

import com.student_management_app.model.Attendance;
import com.student_management_app.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttendanceService {
    
    @Autowired
    private AttendanceRepository attRepo;

    public Optional<Integer> addAttendance(Attendance attendance) {

        attRepo.insertAttendance(attendance);
        return Optional.empty();
    }
    }

    


