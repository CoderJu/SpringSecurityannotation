package com.eleven.service;

import com.eleven.model.User;

/**
 * Created by User on 2017/11/16.
 */
public interface UserService {
    User findById(Integer id);

    User findByUserName(String username);
}
