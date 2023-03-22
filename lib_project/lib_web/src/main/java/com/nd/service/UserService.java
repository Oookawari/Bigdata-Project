package com.nd.service;

import com.nd.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUser(String uid);
}
