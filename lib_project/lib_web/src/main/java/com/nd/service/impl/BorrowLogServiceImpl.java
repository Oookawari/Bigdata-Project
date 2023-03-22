package com.nd.service.impl;

import com.nd.dao.BorrowLogDao;
import com.nd.entity.BorrowLog;
import com.nd.service.BorrowLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-19 16:31
 */
@Service
public class BorrowLogServiceImpl implements BorrowLogService {
    @Autowired
    private BorrowLogDao borrowLogDao;

    @Override
    public List<BorrowLog> findBorrowLog(String bookname, String month) {
        Map<String,Object> map=new HashMap<>();
        map.put("bookname", bookname);
        map.put("month", month);
        List<BorrowLog> borrowLog = borrowLogDao.findBorrowLog(map);
        return borrowLog;
    }
}