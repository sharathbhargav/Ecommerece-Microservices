package com.microservices.ecommerce.Inventory.service;

import com.microservices.ecommerce.Inventory.entity.OrderMessageType;
import com.microservices.ecommerce.Inventory.entity.RequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessIncomingMessage {

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
        log.info("Reverting order with userId="+userId+" orderId="+orderId);
    }

    private void completeOrder(int userId, int orderId) {
        log.info("Completing order of userId="+userId+" orderId="+orderId);
    }

}
