package com.eleven.service;

import com.eleven.dao.UserProfileDao;
import com.eleven.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 2017/11/29.
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    public List<UserProfile> findAll() {
        return userProfileDao.findAll();
    }

    public UserProfile findById(Integer id) {
        return userProfileDao.findById(id);
    }

    public UserProfile findByType(String type) {
        return userProfileDao.findByType(type);
    }
}
