package com.nd.service;

import com.nd.entity.User;
import com.nd.entity.UserLog;

import java.util.List;

public interface UserLogService {

    List<UserLog> findUserLog(String username);
}
