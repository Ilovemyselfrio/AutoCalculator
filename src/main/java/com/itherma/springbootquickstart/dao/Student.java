package com.itherma.springbootquickstart.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id //表示它是一个自增的主键
    //@GeneratedValue(strategy = IDENTITY) 表明是数据库自增，数据是数据库帮我们生成的
    private long id;
    @Column(name="name")//指定实体类属性与数据库表列的映射,表示实体类中的这个字段映射到数据库表中的name列
    //名字相同可以不写，如果类型不同还要convert
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="age")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
