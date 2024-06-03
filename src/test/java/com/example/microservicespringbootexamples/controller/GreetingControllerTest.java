package com.example.microservicespringbootexamples.controller;

import com.example.microservicespringbootexamples.service.ThreadRestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ThreadRestService threadRestService;

    @Test
    void getGreeting() throws Exception {
        String name = "Charles";
        mvc.perform(MockMvcRequestBuilders.get(("/greeting?name=Charles")))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"message\":\"This is just a test, Charles...\"}"));
    }
}