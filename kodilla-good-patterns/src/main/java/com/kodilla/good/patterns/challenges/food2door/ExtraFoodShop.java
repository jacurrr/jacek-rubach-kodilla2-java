package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Manufacturer {
    private final List<Product> list = new ArrayList<>();

    public ExtraFoodShop() {
        list.add(new Product("product 1", new BigDecimal("2.4")));
        list.add(new Product("product 2", new BigDecimal("5.4")));
        list.add(new Product("product 3", new BigDecimal("2.4")));
        list.add(new Product("product 4", new BigDecimal("12.4")));
        list.add(new Product("product 5", new BigDecimal("5.54")));
        list.add(new Product("product 6", new BigDecimal("22.4")));
    }

    @Override
    public void process(Order order) {
        boolean orderResult=true;
        for ( Item item : order.getItems()
        ) {
            if(!list.contains(item.getProduct())){
                orderResult=false;
                break;
            }
        }
        if(orderResult) System.out.println("Confirm Order\n"+order);
        else System.out.println("Dont find product in shop, check your order");
    }

    public List<Product> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ExtraFoodShop";
    }
}
