package com.kodilla.good.patterns.challenges.food2door;

public class Application {
    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();
        Order order = dataRetriever.data();
        order.processOrder();
    }
}
