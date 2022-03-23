package com.microservices.ecommerce.PaymentService.service.kafka;


import com.microservices.ecommerce.PaymentService.entity.RequestMessage;
import com.microservices.ecommerce.PaymentService.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    PaymentService paymentService;

    @KafkaListener(topics = "first_kafka_topic1",groupId = "group_id" )
    public void testListener(String message) {
        log.info("Kafka message "+message);
    }

    @KafkaListener(topics = "${kafkaService.paymentManagement.incomingGroupId}",
            groupId = "${kafkaService.paymentManagement.incomingGroupId}",
            containerFactory = "kafkaListenerOrderContainerFactory")
    public void orderManagementListener(RequestMessage message){
        log.info("Input message of type request message "+message);
        paymentService.handleIncomingRequest(message);
    }

}
