package com.eleven.dao;

import com.eleven.model.User;

import java.util.List;

/**
 * Created by User on 2017/11/16.
 */
public interface UserDao {

    User findById(Integer id);

    User findByUserName(String username);

    void save(User user);

    List<User> findAll();

    void update(User user);


    void deleteUser(User user);
}
