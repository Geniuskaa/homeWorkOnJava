package com.example.hw8.controllers;

import com.example.hw8.services.CalculatorServiceDecorator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorServiceDecorator calculatorServiceDecorator;

    public CalculatorController(CalculatorServiceDecorator calculatorServiceDecorator) {
        this.calculatorServiceDecorator = calculatorServiceDecorator;
    }

    @GetMapping("/sum")
    String sum(String a, String b) {
        return calculatorServiceDecorator.calculate(a, "+", b);
    }

    @GetMapping("/differ")
    String differ(String a, String b) {
        return calculatorServiceDecorator.calculate(a, "-", b);
    }

    @GetMapping("/multiply")
    String multiply(String a, String b) {
        return calculatorServiceDecorator.calculate(a, "*", b);
    }

    @GetMapping("/div")
    String div(String a, String b) {
        return calculatorServiceDecorator.calculate(a, "/", b);
    }
}

