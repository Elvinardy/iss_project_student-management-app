package com.student_management_app.service;

import com.student_management_app.model.EmailSend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailSend email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("elvin.ardy@gmail.com");
        message.setTo(email.getEmailAddress());
        message.setText(email.getMessage());
        message.setSubject(email.getName());

        mailSender.send(message);

        System.out.println("Mail Sent successfully...");

    }
}
