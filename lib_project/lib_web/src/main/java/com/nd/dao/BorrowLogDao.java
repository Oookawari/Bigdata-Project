package com.nd.dao;

import com.nd.entity.BorrowLog;

import java.util.List;
import java.util.Map;

public interface BorrowLogDao {
    List<BorrowLog> findBorrowLog(Map<String,Object> map);
}
