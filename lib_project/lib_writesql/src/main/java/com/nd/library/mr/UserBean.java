package com.nd.library.mr;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBean implements DBWritable, Writable {
    private String uID;
    private String uname;
    private String uage;
    //序列化
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(uID);
        out.writeUTF(uname);
        out.writeUTF(uage);
    }
    //反序列化
    @Override
    public void readFields(DataInput in) throws IOException {
        uID=in.readUTF();
        uname=in.readUTF();
        uage =in.readUTF();
    }
    //数据库写入操作
    @Override
    public void write(PreparedStatement statement) throws SQLException {
        statement.setString(1,this.uID);
        statement.setString(2,this.uname);
        statement.setString(3,this.uage);
    }
    //数据库读取数据操作
    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
//        this.uID=resultSet.getString("uID");
//        this.uname=resultSet.getString("uname");
    }

    public UserBean(){

    }
    public  UserBean(String ID,String name,String age0)
    {
        uID=ID;
        uname=name;
        uage =age0;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage;
    }
}