package com.nd.library.mr;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBean implements DBWritable, Writable {
    private String bID;
    private String bname;
    private String author;
    private String bcategory;
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(bID);
        out.writeUTF(bname);
        out.writeUTF(author);
        out.writeUTF(bcategory);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        bID=in.readUTF();
        bname=in.readUTF();
        author=in.readUTF();
        bcategory=in.readUTF();
    }

    @Override
    public void write(PreparedStatement statement) throws SQLException {
        statement.setString(1,this.bID);
        statement.setString(2,this.bname);
        statement.setString(3,this.author);
        statement.setString(4,this.bcategory);
    }

    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
//        this.bID=resultSet.getString("bID");
//        this.bname=resultSet.getString("bname");
//        this.author=resultSet.getString("author");
//        this.bcategory=resultSet.getString("bcategory");
    }

    public BookBean() {
    }

    public BookBean(String bID, String bname, String author,String bcategory) {
        this.bID = bID;
        this.bname = bname;
        this.author = author;
        this.bcategory = bcategory;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
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

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }
}
