package com.nd.service.impl;

import com.nd.dao.UserDao;
import com.nd.dao.UserLogDao;
import com.nd.entity.User;
import com.nd.entity.UserLog;
import com.nd.service.UserLogService;
import com.nd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 19:47
 */
@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    private UserLogDao userLogDao;
    @Override
    public List<UserLog> findUserLog(String username) {
        List<UserLog> userlogs = userLogDao.findUserLog(username);
        return userlogs;
    }
}