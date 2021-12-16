package com.example.hw8.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public interface Calculator {
    @Bean
    String calculate(String a, String op, String b);
}
