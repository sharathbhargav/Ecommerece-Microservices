package com.microservices.ecommerce.PaymentService.entity;


public enum PaymentMessageType {
    PROCESS_PAYMENT(1),
    REVERSE_PAYMENT(2);

    public final int messageType;
    private PaymentMessageType(int val){
        this.messageType=val;
    }

    @Override
    public String toString() {
        return messageType==1? "PROCESS_PAYMENT" : "REVERSE_PAYMENT";
    }
}
