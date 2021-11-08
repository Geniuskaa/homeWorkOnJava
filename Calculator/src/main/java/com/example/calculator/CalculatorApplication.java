package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        var calc = new Calculator();
        calc.calculate(2,"+",5);
        SpringApplication.run(CalculatorApplication.class, args);
    }

}
