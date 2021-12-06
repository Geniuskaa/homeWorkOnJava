package com.example.hw6;

import org.example.Cl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class Config {

    @RequestScope
    @Bean
    public Cl calculator(){
        return new Cl();
    }

}
