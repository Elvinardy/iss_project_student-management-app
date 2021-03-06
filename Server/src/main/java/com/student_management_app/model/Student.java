package com.student_management_app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String classInfo;
    private String remarks;
    private String phone;
    private String imageUrl;
    @Column(name= "student_code", nullable = false, updatable = false)
    private String studentCode;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    private Attendance attendance;

    /* @ManyToOne
    @JoinColumn(name="class_id")
    private User user; */
    // Empty Constructor
    public Student() { }
    
    public Student(String name, String email, String classInfo, String remarks, String phone, String imageUrl,
            String studentCode, Attendance attendance) {
        this.name = name;
        this.email = email;
        this.classInfo = classInfo;
        this.remarks = remarks;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.studentCode = studentCode;
        this.attendance = attendance;
    
    }

 /*    // Constructor
    public Student(String name, String email, String classInfo, String remarks, String phone, String imageUrl, String studentCode) {
        super();
        this.name = name;
        this.email = email;
        this.classInfo = classInfo;
        this.remarks = remarks;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.studentCode = studentCode;
    } */

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getClassInfo() {
        return classInfo;
    }
    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getStudentCode() {
        return studentCode;
    }
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
    
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
/* 
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", clasInfo='" + classInfo + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
