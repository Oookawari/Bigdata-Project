package com.nd.entity;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 19:42
 */

public class UserLog {
    public String uname;
    public String month;
    public String sumborrow;

    @Override
    public String toString() {
        return "UserLog{" +
                "uname='" + uname + '\'' +
                ", month='" + month + '\'' +
                ", sumborrow='" + sumborrow + '\'' +
                '}';
    }

    public UserLog() {
    }

    public UserLog(String uname, String month, String sumborrow) {
        this.uname = uname;
        this.month = month;
        this.sumborrow = sumborrow;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSumborrow() {
        return sumborrow;
    }

    public void setSumborrow(String sumborrow) {
        this.sumborrow = sumborrow;
    }
}