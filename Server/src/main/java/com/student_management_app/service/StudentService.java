package com.student_management_app.service;

import java.util.List;
import java.util.UUID;

import com.student_management_app.exceptions.UserNotFoundException;
import com.student_management_app.model.Student;
import com.student_management_app.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
   
    @Autowired
    private StudentRepository studentRepo;
    // use this repo to do all the CRUD operations

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString().substring(0,6));
        return studentRepo.save(student);
    } 

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }
    
    public Student findStudentById(Long id) {
        return studentRepo.findStudentById(id)
            .orElseThrow(() -> new UserNotFoundException("Student by this id " + id + " was not found"));
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteStudentById(id);
    }
}
