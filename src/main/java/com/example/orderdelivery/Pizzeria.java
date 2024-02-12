package com.example.orderdelivery;

public class Pizzeria implements Restaurant{
    Integer restaurantId;
    String restaurantName;
    double restaurantLatitude;
    double restaurantLongitude;
    Integer timeTaken;
    Status deliveryAgentStatus;

    public Pizzeria(Integer restaurantId, String restaurantName, Integer restaurantLatitude,Integer restaurantLongitude,Integer timeTaken){
        this.restaurantId=restaurantId;
        this.restaurantName=restaurantName;
        this.restaurantLatitude = restaurantLatitude;
        this.restaurantLongitude = restaurantLongitude;
        this.timeTaken = timeTaken;
    }


    @Override
    public void placeOrder(Delivery delivery) {
        delivery.subscribe(this);
    }
    @Override
    public void update(Status status) {
        this.deliveryAgentStatus = status;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }


}
