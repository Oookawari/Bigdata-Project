package com.nd.service;

import com.nd.entity.BorrowLog;
import com.nd.entity.UserBreak;

import java.util.List;

public interface HotBookService {

    List<BorrowLog> findHotBook1();
    List<BorrowLog> findHotBook2();
    List<BorrowLog> findHotBook3();
    List<BorrowLog> findHotBook4();
    List<BorrowLog> findHotBook5();
    List<BorrowLog> findHotBook6();
}
