package com.nd.library.producer.bean;

public class Borrow {//借书表定义
    private String uid;//
    private String bid;//
    private int month1;//
    private int month2;//
    private int day1;
    private int day2;


    public Borrow(String uid, String bid, int month1,int month2,int day1,int day2) {
        this.uid = uid;
        this.bid = bid;
        this.month1 = month1;
        this.month2 = month2;
        this.day1 = day1;
        this.day2 = day2;
    }

    @Override
    public String toString() {
        return uid +
                "\t" + bid  +
                "\t2022-" + month1 + "-" + day1 +
                "\t2022-" + month2 + "-" + day2;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getMonth1() {
        return month1;
    }

    public void setMonth1(int month1) {
        this.month1 = month1;
    }

    public int getMonth2() {
        return month2;
    }

    public void setMonth2(int month2) {
        this.month2 = month2;
    }

    public int getDay1() {
        return day1;
    }

    public void setDay1(int day1) {
        this.day1 = day1;
    }

    public int getDay2() {
        return day2;
    }

    public void setDay2(int day2) {
        this.day2 = day2;
    }
}

