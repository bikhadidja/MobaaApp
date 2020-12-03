package com.example.mobaapp;

public class Book {

    private String date,time,email,key;

    public Book(String date, String time, String email, String key) {
        this.date = date;
        this.time = time;
        this.email = email;
        this.key = key;
    }

    public Book() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
