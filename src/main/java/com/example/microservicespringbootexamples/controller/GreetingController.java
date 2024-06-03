package com.example.microservicespringbootexamples.controller;

import com.example.microservicespringbootexamples.response.Greeting;
import com.example.microservicespringbootexamples.service.ThreadRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String messageTemplate = "This is just a test, %s...";
    private final AtomicLong counter = new AtomicLong();

    Logger log = LoggerFactory.getLogger(GreetingController .class);

    private ThreadRestService threadRestService;

    public GreetingController(ThreadRestService threadRestService) {
        this.threadRestService = threadRestService;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Devon") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(messageTemplate, name));
    }

    @GetMapping("/greetingcalls")
    public String greetingcalls() {
        String callMessage = threadRestService.call();
        log.info(callMessage);
        return callMessage;
    }
}
