package com.mrbook.model.entity;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {

    private int id;
    private String name;
    private String pass;
    private String phoneNumber;//手机号
    private String email;

    public User(String name, String pass, String phoneNumber, String email) {
        this.name = name;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
