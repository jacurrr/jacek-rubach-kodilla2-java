package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Manufacturer manufacturer;
    private final Customer customer;
    private final List<Item> items = new ArrayList<>();

    public Order(Manufacturer manufacturer, Customer customer) {
        this.manufacturer = manufacturer;
        this.customer = customer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void processOrder(){
        manufacturer.process(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "manufacturer=" + manufacturer +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
