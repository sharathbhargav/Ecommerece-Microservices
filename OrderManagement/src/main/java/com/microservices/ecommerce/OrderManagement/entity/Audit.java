package com.microservices.ecommerce.OrderManagement.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "audit")
public class Audit {
    @Id
    String auditId;
//    @Transient
//    public static final String SEQUENCE_NAME = "audit_sequence";
    Long userId;
    String orderId;
    private PaymentStatus paymentStatus;
    private InventoryStatus inventoryStatus;
    private RefundStatus refundStatus;
    private InventoryRevertStatus inventoryRevertStatus;
}
