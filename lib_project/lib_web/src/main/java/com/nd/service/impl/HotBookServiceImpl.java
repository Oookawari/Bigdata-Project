package com.nd.service.impl;

import com.nd.dao.BorrowLogDao;
import com.nd.dao.HotBookDao;
import com.nd.entity.BorrowLog;
import com.nd.service.HotBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-21 11:15
 */
@Service
public class HotBookServiceImpl implements HotBookService {
    @Autowired
    private HotBookDao hotBookDao;

    @Override
    public List<BorrowLog> findHotBook1() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook1();
        return HotBookList;
    }

    @Override
    public List<BorrowLog> findHotBook2() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook2();
        return HotBookList;
    }

    @Override
    public List<BorrowLog> findHotBook3() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook3();
        return HotBookList;
    }

    @Override
    public List<BorrowLog> findHotBook4() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook4();
        return HotBookList;
    }

    @Override
    public List<BorrowLog> findHotBook5() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook5();
        return HotBookList;
    }

    @Override
    public List<BorrowLog> findHotBook6() {
        List<BorrowLog> HotBookList = hotBookDao.findHotBook6();
        return HotBookList;
    }
}