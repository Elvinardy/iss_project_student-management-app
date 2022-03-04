package com.student_management_app.repository;

import com.student_management_app.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    
}
