package com.nd.entity;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 18:03
 */

public class User {
    public String uid;
    public String uname;
    public String age;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public User(String uid, String uname, String age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}