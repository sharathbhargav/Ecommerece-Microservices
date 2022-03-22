package com.microservices.ecommerce.Inventory.service.kafka;


import com.microservices.ecommerce.Inventory.entity.RequestMessage;
import com.microservices.ecommerce.Inventory.service.ProcessIncomingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    ProcessIncomingMessage processIncomingMessage;

    @KafkaListener(topics = "first_kafka_topic1",groupId = "group_id" )
    public void testListener(String message) {
        log.info("Kafka message "+message);
    }

    @KafkaListener(topics = "${kafkaService.orderManagement.incomingGroupId}",
            groupId = "${kafkaService.orderManagement.incomingGroupId}",
            containerFactory = "kafkaListenerOrderContainerFactory")
    public void orderManagementListener(RequestMessage message){
        log.info("Input message of type request message "+message);
        processIncomingMessage.processMessage(message);
    }

}
