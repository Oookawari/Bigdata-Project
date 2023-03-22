package com.nd.service.impl;

import com.nd.dao.UserSumDao;
import com.nd.entity.UserSum;
import com.nd.service.UserService;
import com.nd.service.UserSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 20:45
 */
@Service
public class UserSumServiceImpl implements UserSumService {
    @Autowired
    private UserSumDao userSumDao;
    @Override
    public List<UserSum> findUserSum() {
        List<UserSum> usersSum = userSumDao.findUserSum();
        return usersSum;
    }
}