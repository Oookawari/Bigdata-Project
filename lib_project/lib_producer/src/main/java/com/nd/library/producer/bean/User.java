package com.nd.library.producer.bean;

import com.nd.library.common.bean.Data;

/**
 * @ClassName:User
 * @Description:用户
 * @Author:huge823865619
 * @Date:2022/7/2 22:12
 * @Version: 1.0
 */
public class User extends Data{
    private String uid;//编号
    private String name;//名字
    private String uage;//年龄

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage;
    }

    public void setValue(Object val) {
        content= (String) val;
        String[] split = content.split("\t");
        setUid(split[0]);
        setName(split[1]);
        setUage(split[2]);
    }

    @Override
    public String toString() {
        return "User[" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ",uage='" + uage + '\'' +
                ']';
    }
}

