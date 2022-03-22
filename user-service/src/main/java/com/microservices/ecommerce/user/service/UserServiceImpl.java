package com.microservices.ecommerce.user.service;

import com.microservices.ecommerce.user.entity.User;
import com.microservices.ecommerce.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        log.info("Inside createUser method of UserService");
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        log.info("Inside findUserById method of UserService");
        return userRepository.findByUserId(userId);
    }
}
