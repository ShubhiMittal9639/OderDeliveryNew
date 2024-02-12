package com.example.orderdelivery;

public interface Delivery {

    void subscribe(Restaurant restaurant); // observer design pattern used to subscribe restaurant so that delivery agent can send its status to all restaurants

    void unsubscribe(Restaurant restaurant); // observer design pattern used to subscribe restaurant so that delivery agent can send its status to all restaurants
    void deliver(Graph graph);
}
