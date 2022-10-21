package com.example.advancedtesting.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/double")
    public String doubleText(@RequestBody String text) {
        return text + text;
    }

}
