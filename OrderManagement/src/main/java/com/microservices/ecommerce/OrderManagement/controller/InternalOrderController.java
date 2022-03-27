package com.microservices.ecommerce.OrderManagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internal/")
@Slf4j
public class InternalOrderController {

    @PostMapping("manage/inventory")
    void fromInventory(){



        log.info("Infrom from inventory ");
    }


    @PostMapping("manage/payment")
    void fromPayment(){
        log.info("Inform from payment service");
    }
}
