package com.example.orafa.androidexercicioactivitiesintentsfacul.model;

/**
 * Created by o Rafa on 25/09/2017.
 */

public class Student {

    private String name;
    private String email;
    private String phone;

    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

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
}
