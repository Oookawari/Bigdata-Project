package com.nd.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 13:19
 */

public class Book implements Serializable {
    public String bid;
    public String bname;
    public String author;
    public String bcategory;

    public Book(String bid, String bname, String author, String bcategory) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.bcategory = bcategory;
    }

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    public Book() {
    }

    public Book(String bid, String bname, String author) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}