package com.microservices.ecommerce.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    Long length;
    Long width;
    Long size;
    Long weight;
    // TODO: find a good way to make product details variable
}
