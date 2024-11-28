package com.luxeserve.user_service.controller;

import com.luxeserve.user_service.entity.Users;
import com.luxeserve.user_service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    // create
    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
       Users users1= userService.saveUser(users);
       return ResponseEntity.status(HttpStatus.CREATED).body(users1);
    }
    int retryCount=1;

    // single user get
    @GetMapping("/getuser/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name="ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<Users> getSingleUser(@PathVariable String userId){
        logger.info("Get Single User Handler: UserController");
        logger.info("Retry count: {}",retryCount);
        retryCount++;
        Users users1=  userService.getUserById(userId);
        return ResponseEntity.ok(users1);
    }
        // creating fallback method for circuitbreaker
   public ResponseEntity<Users> ratingHotelFallback(String userId,Exception ex){

   Users user =    Users.builder().email("info@gmail.com")
               .name("Tapajyoti")
               .about("This is dummy user because some services down")
               .UserId("14568")
               .build();
        return new ResponseEntity<>(user, HttpStatus.TOO_MANY_REQUESTS);
   }

    // all user get
    @GetMapping()
    public ResponseEntity<List<Users>> getUsers(){
       List<Users> alluser= userService.getAllUser();
       return ResponseEntity.ok(alluser);
    }

}
