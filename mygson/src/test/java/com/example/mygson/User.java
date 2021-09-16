package com.example.mygson;

import com.google.gson.annotations.Expose;

public class User {
    public String getUserName() {
        return userName;
    }

    @Expose
    private String userName;

    public String getPassword() {
        return password;
    }

    private String password;
    private int age;
    private boolean isStudent;

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    private Job job;
    @Expose(serialize = false,deserialize = false)
    private int test1;

    private transient int  test2;

    public User(String userName, String password, int age, boolean isStudent) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.isStudent = isStudent;
    }
}
