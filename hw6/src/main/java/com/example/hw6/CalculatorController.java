package com.example.hw6;

import arrow.core.Either;

import org.example.Cl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CalculatorController {
    private Cl calculator;


    public CalculatorController(Cl calculator){
        this.calculator = calculator;
    }

    @GetMapping("/sum")
    public Object add(String a, String b){
        String[] arr = {a, "+", b};
        var c = calculator.calculate(arr);
        return c.fold(i->i, Objects::toString);
    }

    @GetMapping("/minus")
    public Object minus(String a, String b){
        String[] arr = {a, "-", b};
        var c = calculator.calculate(arr);
        return c.fold(i->i, Objects::toString);
    }

    @GetMapping("/div")
    public Object div(String a, String b){
        String[] arr = {a, "/", b};
        var c = calculator.calculate(arr);
        return c.fold(i->i, Objects::toString);
    }

    @GetMapping("/multiply")
    public Object multiply(String a, String b){
        String[] arr = {a, "*", b};
        var c = calculator.calculate(arr);
        return c.fold(i->i, Objects::toString);
    }


}
