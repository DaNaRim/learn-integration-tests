package com.example.advancedtesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MyControllerWebTest {

    private final MockMvc mvc; // not RestTemplate because of MOCK WebEnvironment!

    @Autowired
    public MyControllerWebTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void doubleText() throws Exception {
        mvc.perform(post("/double").content("hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hellohello"));
    }

}
