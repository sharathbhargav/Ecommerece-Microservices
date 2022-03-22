package com.microservices.ecommerce.user.controller;

import com.microservices.ecommerce.user.entity.User;
import com.microservices.ecommerce.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create/")
    public User createUser(@RequestBody User user){
        log.info("Inside createUser method of UserController");
        return userServiceImpl.createUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Inside findUserById method of UserController");
        return userServiceImpl.findUserById(userId);
    }


}
