package com.example.orderdelivery;

public class Customer {
    Integer customerId;
    String customerName;
    double customerLatitude;
    double customerLongitude;

    public Customer(Integer customerId, String customerName, Integer customerLatitude, Integer customerLongitude) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLatitude = customerLatitude;
        this.customerLongitude = customerLongitude;
    }

    public void placeOrder(Restaurant restaurant,DeliveryAgent deliveryAgent) {
        restaurant.placeOrder(deliveryAgent);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerLatitude() {
        return customerLatitude;
    }

    public void setCustomerLatitude(double customerLatitude) {
        this.customerLatitude = customerLatitude;
    }

    public double getCustomerLongitude() {
        return customerLongitude;
    }

    public void setCustomerLongitude(double customerLongitude) {
        this.customerLongitude = customerLongitude;
    }


}
