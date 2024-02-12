package com.example.orderdelivery;

public class FacadeClass {
    public void doDelivery() {
        Graph locationGraph = new Graph(5); // since we have 5 nodes for our usecase

        // Finding location for both the restaurants
        AnandRestaurant anandRestaurant = new AnandRestaurant(0, "Anand", 0, 0, 30); // taken 30 mins instead of pt1

        Pizzeria pizzeriaRestaurant = new Pizzeria(1, "Pizzeria", 1, 1, 40); // taken 30 mins instead of pt1

        // both the customers placing their order at respective restaurants
        Customer customer = new Customer(2, "Jai", 2, 2);

        Customer customer2 = new Customer(3, "Veeru", 3, 3);

        DeliveryAgent deliveryAgent = new DeliveryAgent(4, "Aman", Status.AVAILABLE, 4, 4);

        double anandLatitude = anandRestaurant.getRestaurantLatitude();
        double pizzeriaLatitude = pizzeriaRestaurant.getRestaurantLatitude();
        double anandLongitude = anandRestaurant.getRestaurantLongitude();
        double pizzeriaLongitude = pizzeriaRestaurant.getRestaurantLongitude();
        double deliveryAgentLatitude = deliveryAgent.getDeliveryAgentLatitude();
        double deliveryAgentLongitude = deliveryAgent.getDeliveryAgentLongitude();
        double customer1Latitude = customer.getCustomerId();
        double customer1Longitude = customer.getCustomerLongitude();
        double customer2Latitude = customer2.getCustomerId();
        double customer2Longitude = customer2.getCustomerLongitude();

        locationGraph.addEdge(anandRestaurant.getRestaurantId(), pizzeriaRestaurant.getRestaurantId(), haversine(anandLatitude, anandLongitude, pizzeriaLatitude, pizzeriaLongitude));

        locationGraph.addEdge(anandRestaurant.getRestaurantId(),deliveryAgent.getDeliveryAgentId(),haversine(anandLatitude,anandLongitude,deliveryAgentLatitude,deliveryAgentLongitude));
        locationGraph.addEdge(anandRestaurant.getRestaurantId(),customer.getCustomerId(),haversine(anandLatitude,anandLongitude,customer1Latitude,customer1Longitude));
        locationGraph.addEdge(anandRestaurant.getRestaurantId(),customer2.getCustomerId(),haversine(anandLatitude,anandLongitude,customer2Latitude,customer2Longitude));
        locationGraph.addEdge(pizzeriaRestaurant.getRestaurantId(),deliveryAgent.getDeliveryAgentId(),haversine(pizzeriaLatitude,pizzeriaLongitude,deliveryAgentLatitude,deliveryAgentLongitude));
        locationGraph.addEdge(pizzeriaRestaurant.getRestaurantId(),customer2.getCustomerId(),haversine(pizzeriaLatitude,pizzeriaLongitude,customer2Latitude,customer2Longitude));
        locationGraph.addEdge(pizzeriaRestaurant.getRestaurantId(),customer.getCustomerId(),haversine(pizzeriaLatitude,pizzeriaLongitude,customer1Latitude,customer1Longitude));
        locationGraph.addEdge(customer.getCustomerId(),customer2.getCustomerId(),haversine(customer1Latitude,customer1Longitude,customer2Latitude,customer2Longitude));


        customer.placeOrder(anandRestaurant, deliveryAgent);
        customer2.placeOrder(pizzeriaRestaurant, deliveryAgent);

        deliveryAgent.deliver(locationGraph);
        deliveryAgent.unsubscribe(anandRestaurant);
        deliveryAgent.unsubscribe(pizzeriaRestaurant);
    }

    private static double haversine(double latitude1, double longitude1, double latitude2, double longitude2) {
        double latitude = Math.toRadians(latitude2 - latitude1);
        double longitude = Math.toRadians(longitude2 - longitude1);

        // code to convert latitudes and longitudes to radians
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        double rad = 6371;
        // haversine formula
        double a = Math.pow(Math.sin(latitude / 2), 2) + Math.pow(Math.sin(longitude / 2), 2) * Math.cos(latitude1) * Math.cos(latitude2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}
