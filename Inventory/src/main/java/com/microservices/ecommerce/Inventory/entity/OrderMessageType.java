package com.microservices.ecommerce.Inventory.entity;


public enum OrderMessageType {
    PROCESS_ORDER(1),
    REVERSE_ORDER(2);

    public final int messageType;
    private OrderMessageType(int val){
        this.messageType=val;
    }

    @Override
    public String toString() {
        return messageType==1? "PROCESS_ORDER" : "REVERSE_ORDER";
    }
}
