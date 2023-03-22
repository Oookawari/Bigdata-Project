package com.nd.library.common.constant;

import com.nd.library.common.bean.Val;

public enum Names implements Val {
    TOPIC("library"),
    LIB_INFO("info"),
    LIB_BORROW("borrow"),
    NAMESPACE("library"),
    TABLE("library:borrowlog"),
    ;
    private String name;
    private Names(String name) {this.name = name;}
    public void setValue(Object val) {
        this.name = (String)val;
    }

    public String getValue() {
        return name;
    }
}
