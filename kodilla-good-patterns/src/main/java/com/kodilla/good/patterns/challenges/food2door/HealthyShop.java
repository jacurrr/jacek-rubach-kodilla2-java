package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements Manufacturer {
    private final List<Product> list = new ArrayList<>();

    public HealthyShop() {
        list.add(new Product("product 13", new BigDecimal("10.4")));
        list.add(new Product("product 14", new BigDecimal("21.4")));
        list.add(new Product("product 15", new BigDecimal("34")));
    }

    @Override
    public void process(Order order) {
        boolean result=true;
        for (Item item :
                order.getItems()) {
            if(item.getQuantity()<1) {
                result=false;
                break;
            }
        }
        if(result) System.out.println("Confirm Order\n"+order);
        else System.out.println("Bad quantity in order");
    }

    public List<Product> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ExtraFoodShop";
    }
}
