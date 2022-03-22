package com.microservices.ecommerce.OrderManagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class PublicManagementController {
    @PostMapping("/create/{id}")
    public void createOrderForUserId(@PathVariable("id") Long userId){
        log.info("Post request of /create/"+userId);
    }

    @GetMapping("/status/{id}")
    public void getOrderStatus(@PathVariable("id") Long userId){
        log.info("Get request of status/"+userId);
    }
}
