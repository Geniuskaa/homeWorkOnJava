package com.example.hw8.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "cache")
public class Cache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "a", nullable = false)
    private String a;

    @Column(name = "b", nullable = false)
    private String b;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "result", nullable = false)
    private String result;

    public Cache() {

    }
}