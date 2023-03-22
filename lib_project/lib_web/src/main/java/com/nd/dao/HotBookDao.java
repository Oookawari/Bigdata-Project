package com.nd.dao;

import com.nd.entity.BorrowLog;

import java.util.List;

public interface HotBookDao {
    List<BorrowLog> findHotBook1();
    List<BorrowLog> findHotBook2();
    List<BorrowLog> findHotBook3();
    List<BorrowLog> findHotBook4();
    List<BorrowLog> findHotBook5();
    List<BorrowLog> findHotBook6();
}