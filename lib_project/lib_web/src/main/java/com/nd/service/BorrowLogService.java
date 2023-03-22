package com.nd.service;

import com.nd.entity.BorrowLog;

import java.util.List;

public interface BorrowLogService {
    List<BorrowLog> findBorrowLog(String bookname, String month);
}
