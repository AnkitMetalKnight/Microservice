package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserServiceImpl;
import com.lcwd.user.service.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    int retryCount = 1;

    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "UserRateLimiter", fallbackMethod = "ratingHotelService")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)

    {
        logger.info("Retry count : {}" , retryCount);
        retryCount++;
        logger.info("Get Single User Handler: UserController");
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }


    //creating fall back method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
//        logger.info("Fallback is called as some service is down " + ex.getMessage());

        User user = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("A dummy is created for an exception")
                .userId("123456")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok(user);
    }
}
