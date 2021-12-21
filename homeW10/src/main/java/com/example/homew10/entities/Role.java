package com.example.homew10.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}