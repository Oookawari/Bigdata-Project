package com.nd.entity;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 20:42
 */

public class UserSum {
    private Integer uid;
    private String uname;
    private Integer sumborrow;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getSumborrow() {
        return sumborrow;
    }

    public void setSumborrow(Integer sumborrow) {
        this.sumborrow = sumborrow;
    }

    public UserSum(Integer uid, String uname, Integer sumborrow) {
        this.uid = uid;
        this.uname = uname;
        this.sumborrow = sumborrow;
    }

    public UserSum() {
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", sumborrow=" + sumborrow +
                '}';
    }
}