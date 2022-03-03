package com.student_management_app.controllers;

import java.util.List;

import com.student_management_app.model.Student;
import com.student_management_app.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    
    @Autowired
    StudentService studentSvc;

    public StudentRestController(StudentService studentSvc) {
        this.studentSvc = studentSvc;
    }

    // get all students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
       
        List<Student> students = studentSvc.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // Find by Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable("id") Long id) {
       
        Student student = studentSvc.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    // expecting student object in Json format
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentSvc.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    
    // to update student information
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updateStudent = studentSvc.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.CREATED);
    }
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        studentSvc.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
