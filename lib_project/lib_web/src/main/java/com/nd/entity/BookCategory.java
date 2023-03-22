package com.nd.entity;

public class BookCategory {
    private String bcategory;
    private String num;

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public BookCategory(String bcategory, String num) {
        this.bcategory = bcategory;
        this.num = num;
    }

    public BookCategory() {
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "bcategory='" + bcategory + '\'' +
                ", num=" + num +
                '}';
    }
}