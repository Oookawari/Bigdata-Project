package com.nd.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-19 16:16
 */

public class BorrowLog implements Serializable {
    public String bname;
    public String month;
    public String sumborrow;

    public BorrowLog(String bname, String month, String sumborrow) {
        this.bname = bname;
        this.month = month;
        this.sumborrow = sumborrow;
    }

    public BorrowLog() {
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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

    @Override
    public String toString() {
        return "BorrowLog{" +
                "bname='" + bname + '\'' +
                ", month='" + month + '\'' +
                ", sumborrow='" + sumborrow + '\'' +
                '}';
    }
}