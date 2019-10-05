package com.example.myapplication;

import java.io.Serializable;

public class Contact2 implements Serializable {
    private String name;
    private String mess;

    public Contact2(String name, String mess) {
        this.name = name;
        this.mess = mess;
    }

    public Contact2() {
    }

    public String getName() {
        return name;
    }

    public String getMess() {
        return mess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
