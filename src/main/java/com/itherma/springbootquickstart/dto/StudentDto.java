package com.itherma.springbootquickstart.dto;

import jakarta.persistence.Column;

public class StudentDto {
    private long id;
    private String name;
    private String email;
    //private int age;  如age字段 我们就不返回给前端

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
