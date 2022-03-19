package com.microservices.ecommerce.Inventory.error;

public class InvalidQuantityException extends Exception{

    public InvalidQuantityException(){
        super();
    }
    public InvalidQuantityException(String msg){
        super(msg);
    }
    public InvalidQuantityException(String msg,Throwable cause){
        super(msg,cause);
    }


}
