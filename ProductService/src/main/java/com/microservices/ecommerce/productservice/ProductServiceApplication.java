package com.microservices.ecommerce.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
