package com.eleven.config.core;

import com.eleven.model.UserProfile;
import com.eleven.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/11/30.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfile convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        UserProfile userProfile = userProfileService.findById(id);
        System.out.println("Profile : "+userProfile);
        return userProfile;
    }

    /*public UserProfile convert(Object o) {
        String type = (String) o;
        UserProfile userProfile = userProfileService.findByType(type);
        System.out.println("Profile : "+userProfile);
        return userProfile;
    }*/
}
