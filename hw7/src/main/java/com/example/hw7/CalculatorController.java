package com.example.hw7;

import arrow.core.Either;
import org.example.Calculator;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;


@RestController
public class CalculatorController {
    private final Calculator calculator;
    private final Session session;

    public CalculatorController(Calculator calculator, Session session) {
        this.calculator = calculator;
        this.session = session;
    }

    private String returnResult(String a, String operator, String b) {
        String result;
        session.beginTransaction();
        Query query = session.createQuery("from Cache where firstArgument=:a and secondArgument=:b and operator=:operator");
        query.setParameter("a", a);
        query.setParameter("b", b);
        query.setParameter("operator", operator);
        List list = query.list();

        if (list.isEmpty()) {
            Either<String, Integer> resultEither = switch (operator) {
                case "+" -> calculator.calculate(a, "+", b);
                case "-" -> calculator.calculate(a, "-", b);
                case "/" -> calculator.calculate(a, "/", b);
                default -> calculator.calculate(a, "*", b);
            };

            result = resultEither.fold(i -> i, Objects::toString);
            session.save(new Cache(a, b, operator, result));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Cache cache = (Cache) list.get(0);
            result = cache.getResult()  + " (from cache)";
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @GetMapping("/sum")
    public String add(String a, String b) {
        return returnResult(a, "+", b);

    }

    @GetMapping("/differ")
    public String differ(String a, String b) {
        return returnResult(a, "-", b);
    }

    @GetMapping("/multiply")
    public String multiply(String a, String b) {
        return returnResult(a, "*", b);
    }

    @GetMapping("/div")
    public String div(String a, String b) {
        return returnResult(a, "/", b);
    }


}
