package com.nd.dao;

import com.nd.entity.User;
import com.nd.entity.UserLog;

import java.util.List;

public interface UserLogDao {

    List<UserLog> findUserLog(String uname);
}
