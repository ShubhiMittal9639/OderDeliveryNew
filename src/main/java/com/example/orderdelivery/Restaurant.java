package com.example.orderdelivery;

public interface Restaurant {
    void update(Status status);
    void placeOrder(Delivery delivery);
}
