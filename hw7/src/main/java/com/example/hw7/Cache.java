package com.example.hw7;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cache")
public class Cache {
    private Long id;

    private String firstArgument;
    private String secondArgument;
    private String operator;
    private String result;

    public Cache() {
    }

    public Cache(String firstArgument, String secondArgument, String operator, String result) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.operator = operator;
        this.result = result;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_argument")
    public String getFirstArgument() {
        return firstArgument;
    }

    public void setFirstArgument(String firstArgument) {
        this.firstArgument = firstArgument;
    }

    @Column(name = "second_argument")
    public String getSecondArgument() {
        return secondArgument;
    }

    public void setSecondArgument(String secondArgument) {
        this.secondArgument = secondArgument;
    }

    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
