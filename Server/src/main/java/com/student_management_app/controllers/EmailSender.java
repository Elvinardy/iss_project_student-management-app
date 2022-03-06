package com.student_management_app.controllers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.student_management_app.model.EmailSend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@RequestMapping("/student")
@Controller
@CrossOrigin
public class EmailSender {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    SpringTemplateEngine templateEngine;

    @CrossOrigin
    @RequestMapping("/sendmail")
    public @ResponseBody EmailSend sendEmail(@RequestBody EmailSend send) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                            StandardCharsets.UTF_8.name());
                            
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", send.getName());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(send.getEmailAddress());
            helper.setText(send.getMessage(), html);
            helper.setFrom(send.getName());
            helper.setSubject("Notification!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
        return send;
    }

    
}
