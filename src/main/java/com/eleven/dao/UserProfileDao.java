package com.eleven.dao;

import com.eleven.model.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2017/11/29.
 */

public interface UserProfileDao {
    List<UserProfile> findAll();

    UserProfile findById(Integer id);

    UserProfile findByType(String type);
}
