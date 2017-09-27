package com.example.orafa.androidexercicioactivitiesintentsfacul.model;

import java.io.Serializable;

/**
 * Created by o Rafa on 25/09/2017.
 */

public class Student implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
