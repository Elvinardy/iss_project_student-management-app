package com.student_management_app.model;

public class ResponseMail {
    private String message;

    
    public ResponseMail() {
    }

    public ResponseMail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
