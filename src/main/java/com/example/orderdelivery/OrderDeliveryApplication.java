package com.example.orderdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDeliveryApplication.class, args);

        FacadeClass facadeClass = new FacadeClass();
        facadeClass.doDelivery();

    }

}
