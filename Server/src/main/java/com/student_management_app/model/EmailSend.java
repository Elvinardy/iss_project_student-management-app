package com.student_management_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmailSend {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String subject;
    private String emailAddress;
    private String message;

    
    public EmailSend(String name, String subject, String emailAddress, String message) {
        super();
        this.name = name;
        this.subject = subject;
        this.emailAddress = emailAddress;
        this.message = message;
    }

    public EmailSend() {
    }
    
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
