package com.microservices.ecommerce.PaymentService.entity;

public enum PaymentStatus {
    PAYMENT_COMPLETE(30),
    PAYMENT_REFUND(40);

    public final int paymentStatus;

    private PaymentStatus(int val){
        this.paymentStatus=val;
    }


}
