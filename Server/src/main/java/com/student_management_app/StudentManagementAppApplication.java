package com.student_management_app;

import com.student_management_app.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementAppApplication {

	@Autowired
	private EmailService sendService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementAppApplication.class, args);
	}

/*  @EventListener(ApplicationReadyEvent.class)
	public ResponseEntity<EmailSend> sendMail(@RequestBody EmailSend email) {
		sendService.sendEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}	 
 */
}
