package com.student_management_app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance_info")
public class Attendance implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="atd_id")
    private long atdId;

    @Column(name="date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name="atd_info")
    private AtdInfo atdInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id", nullable = false)
    private Student student;

   
    public Attendance() {
    }

    public Attendance(long atdId, Date date, AtdInfo atdInfo, Student student) {
        this.atdId = atdId;
        this.date = date;
        this.atdInfo = atdInfo;
        this.student = student;
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

    @Override
    public String toString() {
        return "Attendance {" +
                "id=" + atdId +
                ", atd_info='" + atdInfo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
