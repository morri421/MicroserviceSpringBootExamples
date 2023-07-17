package com.example.microservicespringbootexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceSpringBootExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSpringBootExamplesApplication.class, args);
    }

    //Make sure you hook up Redis and Kafka and a database
    //Automated testing


}
