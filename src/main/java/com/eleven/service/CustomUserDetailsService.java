package com.eleven.service;

import com.eleven.model.User;
import com.eleven.model.UserProfile;
import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/11/16.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService  implements UserDetailsService{


    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        System.out.println(">>>>>>>>>"+user);
        if (null == user){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return  new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassWord(),
                user.getState().equals("Active"),true,true,true,
                getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UserProfile userProfile : user.getUserProfiles()) {
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
