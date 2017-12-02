package com.eleven.service;

import com.eleven.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 2017/11/29.
 */

public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findById(Integer id);

    UserProfile findByType(String type);
}
