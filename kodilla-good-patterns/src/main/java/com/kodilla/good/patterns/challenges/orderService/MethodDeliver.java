package com.kodilla.good.patterns.challenges.orderService;

public class MethodDeliver {
    private String name;
    private String addressFrom;
    private String addressTo;
    private double price;

    public MethodDeliver(final String name, final String addressFrom, final String addressTo, final double price) {
        this.name = name;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public double getPrice() {
        return price;
    }
}
