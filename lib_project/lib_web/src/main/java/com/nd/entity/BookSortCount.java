package com.nd.entity;

public class BookSortCount {
    private String bcategory;
    private String sumborrow;

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    public String getSumborrow() {
        return sumborrow;
    }

    public void setSumborrow(String sumborrow) {
        this.sumborrow = sumborrow;
    }

    public BookSortCount(String bcategory, String sumborrow) {
        this.bcategory = bcategory;
        this.sumborrow = sumborrow;
    }

    public BookSortCount() {
    }

    @Override
    public String toString() {
        return "BookSortCount{" +
                "bcategory='" + bcategory + '\'' +
                ", sumborrow=" + sumborrow +
                '}';
    }
}
