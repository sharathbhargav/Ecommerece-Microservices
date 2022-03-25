package com.microservices.ecommerce.PaymentService.service;

import com.microservices.ecommerce.PaymentService.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public void handleIncomingRequest(RequestMessage message){
        PaymentMessageType messageType = message.getMessageType();
        Long orderId = message.getOrderId();
        Long cartId = message.getCartId();
        Payment payment= Payment.builder().order_id(orderId).paymentMessage(
                "Dummy message").build();
        switch (messageType){
            case PROCESS_PAYMENT:
                payment.setPaymentStatus(PaymentStatus.PAYMENT_COMPLETE);
                paymentRepository.save(payment);
                // todo make request to order management service telling
                //  payment was successful after random n seconds
                break;
            case REVERSE_PAYMENT:
                Long paymentId = message.getPaymentId();
                Optional<Payment> oldPayment =
                        paymentRepository.findById(paymentId);
                if(oldPayment.isPresent()){
                    Payment p = oldPayment.get();
                    p.setPaymentStatus(PaymentStatus.PAYMENT_REFUND);
                    paymentRepository.save(p);
                    //todo make request to order management service telling
                    // payment refund successful
                }
                else {
                    System.out.println("Payment id not found for id = " + paymentId);
                    //todo make request to order management service telling
                    // payment id not found
                }
                break;
        }
    }
}
