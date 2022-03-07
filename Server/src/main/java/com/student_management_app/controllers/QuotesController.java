package com.student_management_app.controllers;

import com.student_management_app.service.QuotesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Controller
@RequestMapping(path="/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuotesController {
    
    @Autowired
    QuotesService quotesService;

    @GetMapping(path = "/quote")
    public ResponseEntity<String> getHome() {

//        add quote into json and send over
        String quote = quotesService.getQuote();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("quote", quote)
                .build();
        return ResponseEntity.ok(jsonObject.toString());
    }
}
