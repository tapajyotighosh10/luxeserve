package com.luxeserve.user_service.service;

import com.luxeserve.user_service.entity.Users;

import java.util.List;

public interface UserService {
    // user operation

    // create
    Users saveUser(Users users);

    // get all user
    List<Users> getAllUser();

    // get single user by id

    Users getUserById(String userId);
       // TODO: delete
    // TODO: update


}
