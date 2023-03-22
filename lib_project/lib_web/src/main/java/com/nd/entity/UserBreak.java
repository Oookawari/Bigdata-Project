package com.nd.entity;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-21 00:31
 */

public class UserBreak {
    public String uid;
    public String uname;
    public String breakTimes;

    public UserBreak() {
    }

    public UserBreak(String uid, String uname, String breakTimes) {
        this.uid = uid;
        this.uname = uname;
        this.breakTimes = breakTimes;
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

    public String getBreakTimes() {
        return breakTimes;
    }

    public void setBreakTimes(String breakTimes) {
        this.breakTimes = breakTimes;
    }

    @Override
    public String toString() {
        return "Userbreak{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", breakTimes='" + breakTimes + '\'' +
                '}';
    }
}