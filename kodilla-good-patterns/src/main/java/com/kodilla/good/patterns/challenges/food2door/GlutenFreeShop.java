package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements Manufacturer{
    private final List<Product> list = new ArrayList<>();

    public GlutenFreeShop() {
        list.add(new Product("product 7", new BigDecimal(0.4)));
        list.add(new Product("product 8", new BigDecimal(1.4)));
        list.add(new Product("product 9", new BigDecimal(24)));
        list.add(new Product("product 10", new BigDecimal(14)));
        list.add(new Product("product 11", new BigDecimal(2.51)));
        list.add(new Product("product 12", new BigDecimal(3.6)));
    }

    @Override
    public void process(Order order) {
        boolean productNotMatched = false;
        BigDecimal totalPrice = BigDecimal.ZERO;
        for( Item item : order.getItems()) {
            if(!list.contains(item.getProduct())){
                productNotMatched = true;
                break;
            }
            totalPrice = totalPrice.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        if(productNotMatched){
            System.out.println("Dont find product in shop, check your order");
        } else System.out.println("Confirm Order\n"+order+"\nTotal Price"+totalPrice.setScale(2, RoundingMode.UP));
    }

    public List<Product> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "GlutenFreeShop";
    }
}
