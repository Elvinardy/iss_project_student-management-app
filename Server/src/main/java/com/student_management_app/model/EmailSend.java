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
    private String email;
    private String subject;
    private String message;

    
    public EmailSend(String name, String email, String message, String subject) {
        super();
        this.name = name;
        this.email = email;
        this.message = message;
        this.message = message;
    }

    public EmailSend() {
    }

    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
