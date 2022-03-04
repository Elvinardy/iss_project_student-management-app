package com.student_management_app.model;

public class JwtRequest {
    
    private String userName;
    private String password;

    public String getUsername() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public JwtRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public JwtRequest() {
    }

    
    
}
 