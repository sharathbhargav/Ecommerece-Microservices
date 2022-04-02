package com.microservices.ecommerce.OrderManagement.entity;

import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    String orderId;
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
    Long timeStamp;
    @NonNull
    Long userId;
    Long paymentId = null;
    List<OrderItems> items = new ArrayList<>();
}
