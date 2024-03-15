package com.destaproject.core;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = {"com.destaproject"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        // Set Spring Boot TimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7:00"));
    }
}
