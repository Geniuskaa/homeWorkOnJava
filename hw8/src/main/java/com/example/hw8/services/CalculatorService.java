package com.example.hw8.services;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService implements Calculator {
    @Override
    public String calculate(String a, String op, String b) {

        Integer val1 = parseToInt(a);
        Integer val2 = parseToInt(b);

        if (val1 == null || val2 == null) return "Incorrect values";

        return switch (op) {
            case "+" -> String.valueOf(val1 + val2);
            case "-" -> String.valueOf(val1 - val2);
            case "*" -> String.valueOf(val1 * val2);
            case "/" -> String.valueOf(val1 / val2);
            default -> "Incorrect or operator";
        };
    }

    Integer parseToInt(String value) {
        try {
            return Integer.parseInt(value);

        } catch (Exception e) {
            return null;
        }
    }

}
