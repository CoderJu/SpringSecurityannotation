package com.eleven.model;

/**
 * Created by User on 2017/11/16.
 */
public enum UserProfileType {
    USER("USER"),
    ADMIN("ADMIN"),
    DBA("DBA");

   private  String  userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }


}
