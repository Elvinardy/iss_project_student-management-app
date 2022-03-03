package com.student_management_app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")

public class Attendance implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="atd_id")
    private Long atdId;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

   
    @Column(name="date")
    private Date date;

    @Column(name="atd_info")
    private AtdInfo atdInfo;

    public Attendance() {
    }

    public Attendance(Student student, Date date, AtdInfo atdInfo) {
        this.student = student;
        this.date = date;
        this.atdInfo = atdInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAtdId() {
        return atdId;
    }

    public void setAtdId(Long atdId) {
        this.atdId = atdId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AtdInfo getAtdInfo() {
        return atdInfo;
    }

    public void setAtdInfo(AtdInfo atdInfo) {
        this.atdInfo = atdInfo;
    }

}
