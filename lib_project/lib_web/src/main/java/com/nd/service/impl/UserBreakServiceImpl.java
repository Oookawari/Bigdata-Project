package com.nd.service.impl;

import com.nd.dao.UserBreakDao;
import com.nd.dao.UserLogDao;
import com.nd.entity.UserBreak;
import com.nd.entity.UserLog;
import com.nd.service.UserBreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-21 00:31
 */
@Service
public class UserBreakServiceImpl implements UserBreakService {
    @Autowired
    private UserBreakDao userBreakDao;

    @Override
    public List<UserBreak> findUserBreak() {
        List<UserBreak> Users = userBreakDao.findUserBreak();
        return Users;
    }
}