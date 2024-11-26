package com.luxeserve.user_service.service.impl;

import com.luxeserve.user_service.entity.Users;
import com.luxeserve.user_service.exceptions.ResourceNotFound;
import com.luxeserve.user_service.repository.UserRepository;
import com.luxeserve.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users users) {
        //generate a unique user id in string format
       String randomUserID= UUID.randomUUID().toString();
        users.setUserId(randomUserID);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFound("User with given id is not found on server !!:"+userId));
    }
}
