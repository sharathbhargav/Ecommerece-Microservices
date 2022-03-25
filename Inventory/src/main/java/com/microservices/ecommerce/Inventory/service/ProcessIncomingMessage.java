package com.microservices.ecommerce.Inventory.service;

import com.microservices.ecommerce.Inventory.entity.OrderMessageType;
import com.microservices.ecommerce.Inventory.entity.RequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ProcessIncomingMessage {

//    @Autowired
//    private RestTemplate restTemplate;


    public void processMessage(RequestMessage message){
        OrderMessageType orderMessageType = message.getMessageType();
        int userId = message.getCartId();
        int orderId = message.getOrderId();

        switch (orderMessageType){
            case PROCESS_ORDER:
                completeOrder(userId,orderId);
                break;
            case REVERSE_ORDER:
                revertOrder(userId,orderId);
                break;
        }
    }

    private void revertOrder(int userId, int orderId) {
        // TODO Get details of cart for the order id and add the quantity of
        //  each product back to inventory. Send success message or failure
        //  message

        log.info("Reverting order with userId="+userId+" orderId="+orderId);
    }

    private void completeOrder(int userId, int orderId) {
        //TODO Get details from cart and see if enough inventory is there for
        // all and if true then subtract cart items from inventory and send
        // success message, else send failure message

        log.info("Completing order of userId="+userId+" orderId="+orderId);
    }

}
