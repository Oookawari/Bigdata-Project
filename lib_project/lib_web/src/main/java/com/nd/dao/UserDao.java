package com.nd.dao;


import com.nd.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findUser(String uid);
}