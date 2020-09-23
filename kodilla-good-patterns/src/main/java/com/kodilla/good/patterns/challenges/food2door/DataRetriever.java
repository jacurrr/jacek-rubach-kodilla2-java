package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;

public class DataRetriever {
    public Order data(){
        Customer customer = new Customer("Adam","Miałczyński","Wrocław, Grabiszyńska 15");
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        Product product = glutenFreeShop.getList().get(0);
        Product product2 = glutenFreeShop.getList().get(1);
        Product product3 = glutenFreeShop.getList().get(2);
        Item item = new Item(product,2);
        Item item2 = new Item(product2,1);
        Item item3 = new Item(product3,4);
        Order result = new Order(glutenFreeShop,customer);
        result.getItems().add(item);
        result.getItems().add(item2);
        result.getItems().add(item3);
        return result;
    }
}
