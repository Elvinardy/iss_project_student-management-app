package com.student_management_app.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.student_management_app.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Transactional
    void deleteStudentById(Long id);
    // query method in Spring
    Optional<Student> findStudentById(Long id);
/* 
    Optional<Student> findStudentByUser(); */
}
