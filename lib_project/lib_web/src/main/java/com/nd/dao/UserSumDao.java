package com.nd.dao;

import com.nd.entity.UserLog;
import com.nd.entity.UserSum;

import java.util.List;

public interface UserSumDao {
    List<UserSum> findUserSum();
}
