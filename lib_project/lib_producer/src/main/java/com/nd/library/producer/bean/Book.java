package com.nd.library.producer.bean;

import com.nd.library.common.bean.Data;

public class Book extends Data{
    private String bid;
    private String name;
    private String author;//作者
    private String bcategory;//书类别

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBcategory(){
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    public void setValue(Object val) {
        content= (String) val;
        String[] split = content.split("\t");
        setBid(split[0]);
        setName(split[1]);
        setAuthor(split[2]);
        setBcategory(split[3]);
    }

    @Override
    public String toString() {
        return "User[" +
                "bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                "author=" + author + '\'' +
                "bcategory="+bcategory+'\''+
                ']';
    }
}
