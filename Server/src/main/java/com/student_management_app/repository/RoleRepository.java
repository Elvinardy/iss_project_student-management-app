package com.student_management_app.repository;

import com.student_management_app.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  // using CRUD repository
public interface RoleRepository extends CrudRepository<Role, String> {
    

}
