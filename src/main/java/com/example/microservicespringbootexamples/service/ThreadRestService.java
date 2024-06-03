package com.example.microservicespringbootexamples.service;

import com.example.microservicespringbootexamples.response.Greeting;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ThreadRestService {

    //This is silly. It would never be done this way. If I had access to the date, there is no reason to even make it a call.
    public String call() {
        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject(
                "http://localhost:8080/greeting?name=Devon", Greeting.class);
        return greeting.toString();
    }
}