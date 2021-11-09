package com.example.hw6;

import arrow.core.Either;

import org.example.Cl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private Cl calculator;


    public CalculatorController(Cl calculator){
        this.calculator = calculator;
    }

    @GetMapping("/sum")
    public Either<Cl.CalculatorException.WrongArgument, Number> add(String a, String b){
        String[] arr = {a, "+", b};
        return calculator.calculate(arr);
    }

    @GetMapping("/minus")
    public Either<Cl.CalculatorException.WrongArgument, Number> minus(String a, String b){
        String[] arr = {a, "-", b};
        return calculator.calculate(arr);
    }

    @GetMapping("/div")
    public Either<Cl.CalculatorException.WrongArgument, Number> div(String a, String b){
        String[] arr = {a, "/", b};
        return calculator.calculate(arr);
    }

    @GetMapping("/multiply")
    public Either<Cl.CalculatorException.WrongArgument, Number> multiply(String a, String b){
        String[] arr = {a, "*", b};
        return calculator.calculate(arr);
    }


}
