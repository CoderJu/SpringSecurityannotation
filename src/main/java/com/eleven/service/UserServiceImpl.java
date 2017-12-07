package com.eleven.service;

import com.eleven.dao.UserDao;
import com.eleven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 2017/11/16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    public void save(User user) {
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void edit(User user) {
        User exitUser = userDao.findById(user.getId());
        exitUser.setFirstName(user.getFirstName());
        exitUser.setLastName(user.getLastName());
        exitUser.setUserName(user.getUserName());
        userDao.update(exitUser);
    }

    public void delete(int id) {
        User user = userDao.findById(id);
        userDao.deleteUser(user);
    }
}
