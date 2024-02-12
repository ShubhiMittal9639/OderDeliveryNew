package com.example.orderdelivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent implements Delivery {
    Integer deliveryAgentId;
    String deliveryAgentName;
    Status status;
    double deliveryAgentLatitude;
    double deliveryAgentLongitude;
    List<Restaurant> restaurants = new ArrayList<>();


    public DeliveryAgent(Integer deliveryAgentId,String deliveryAgentName, Status status,double deliveryAgentLatitude,double deliveryAgentLongitude) {
        this.deliveryAgentId = deliveryAgentId;
        this.deliveryAgentName=deliveryAgentName;
        this.status = status;
        this.deliveryAgentLatitude = deliveryAgentLatitude;
        this.deliveryAgentLongitude=deliveryAgentLongitude;
    }


    @Override
    public void subscribe(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    @Override
    public void unsubscribe(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }

    @Override
    public void deliver(Graph graph){
        // if two restaurants already sent request to deliver than mark this agent as busy
        if (restaurants.size() > 2) {
            for (Restaurant restaurant : restaurants) {
                restaurant.update(Status.BUSY);
            }
        }
        // deliver if agent is available
        if(status.equals(Status.AVAILABLE)){

        }

       // mark the status again as available
        for (Restaurant restaurant : restaurants) {
            restaurant.update(Status.AVAILABLE);
        }
    }

    public Integer getDeliveryAgentId() {
        return deliveryAgentId;
    }

    public void setDeliveryAgentId(Integer deliveryAgentId) {
        this.deliveryAgentId = deliveryAgentId;
    }

    public String getDeliveryAgentName() {
        return deliveryAgentName;
    }

    public void setDeliveryAgentName(String deliveryAgentName) {
        this.deliveryAgentName = deliveryAgentName;
    }

    public double getDeliveryAgentLatitude() {
        return deliveryAgentLatitude;
    }

    public void setDeliveryAgentLatitude(double deliveryAgentLatitude) {
        this.deliveryAgentLatitude = deliveryAgentLatitude;
    }

    public double getDeliveryAgentLongitude() {
        return deliveryAgentLongitude;
    }

    public void setDeliveryAgentLongitude(double deliveryAgentLongitude) {
        this.deliveryAgentLongitude = deliveryAgentLongitude;
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
