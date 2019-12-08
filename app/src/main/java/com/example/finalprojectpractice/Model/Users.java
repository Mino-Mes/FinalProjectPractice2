package com.example.finalprojectpractice.Model;

public class Users {
    private String fname;
    private int age;
    private String email;

    public Users(String fname, int age, String email) {
        this.fname = fname;
        this.age = age;
        this.email = email;
    }

    public Users() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
