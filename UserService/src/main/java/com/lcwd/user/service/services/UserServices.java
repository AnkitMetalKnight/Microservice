package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserServices {

    //create user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get a user by id
    User getUser(String userId);

}
