package com.example.microservicespringbootexamples.controller;

import com.example.microservicespringbootexamples.response.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String messageTemplate = "This is just a test, %s...";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Devon") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(messageTemplate, name));
    }
}
