package com.example.orafa.androidexercicioactivitiesintentsfacul.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by o Rafa on 25/09/2017.
 */

public class Student implements Serializable{

    private String name;
    private String email;
    private String phone;
    private String site;

    public Student(String name, String email, String phone, String site) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.site = site;
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

    public String getSite() {
        return site;
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

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return name;
    }

}
