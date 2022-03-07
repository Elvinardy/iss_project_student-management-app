/* package com.student_management_app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class User implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false, updatable = false)
    private Long teacherId; 
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Student> students;

    

    public User() {
    }

    public User(Long teacherId, String name, String email, List<Student> students) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.students = students;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    
    @Override
    public String toString() {
        return "User {" +
                "id=" + teacherId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    

} */
