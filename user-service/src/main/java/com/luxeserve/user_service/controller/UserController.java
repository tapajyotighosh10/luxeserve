package com.luxeserve.user_service.controller;

import com.luxeserve.user_service.entity.Users;
import com.luxeserve.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    // create
    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
       Users users1= userService.saveUser(users);
       return ResponseEntity.status(HttpStatus.CREATED).body(users1);
    }

    // single user get
    @GetMapping("/getuser/{userId}")
    public ResponseEntity<Users> getSingleUser(@PathVariable String userId){
        Users users1=  userService.getUserById(userId);
        return ResponseEntity.ok(users1);
    }

    // all user get
    @GetMapping()
    public ResponseEntity<List<Users>> getUsers(){
       List<Users> alluser= userService.getAllUser();
       return ResponseEntity.ok(alluser);
    }

}
