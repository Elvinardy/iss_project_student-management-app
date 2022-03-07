package com.student_management_app.controllers;

import com.student_management_app.model.EmailSend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RequestMapping("/student")
@Controller
@CrossOrigin
public class EmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private JavaMailSender sender;


    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailSend send) throws Exception {
        logger.info(">>> Email: " + send.getEmail());
        logger.info(send.getMessage());

        JsonObject resp;
    
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("elvin.ardy@gmail.com");
        message.setTo(send.getEmail());
        message.setSubject(send.getSubject());
        message.setText(send.getMessage());
        sender.send(message);

        resp = Json.createObjectBuilder()
				.add("message sent" , send.getMessage())
				.build();
			return ResponseEntity.ok().body(resp.toString());

    }

    
}
