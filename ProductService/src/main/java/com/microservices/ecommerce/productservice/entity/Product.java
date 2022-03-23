package com.microservices.ecommerce.productservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    String id;

    @Transient
            public static final String SEQUENCE_NAME = "product_sequence";
    Long productId;
    @NonNull
    List<String> category;
    @NonNull
    String title;
    @NonNull
    String description;
    @NonNull
    Double price;
    ProductDetails productDetails;
}
