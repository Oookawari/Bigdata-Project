package com.nd.service.impl;

import com.nd.dao.UserDao;
import com.nd.entity.User;
import com.nd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 18:05
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findUser(String uid) {
        List<User> users = userDao.findUser(uid);
        return users;
    }
}