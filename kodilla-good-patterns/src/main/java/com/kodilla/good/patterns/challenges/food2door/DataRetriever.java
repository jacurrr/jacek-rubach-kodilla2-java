package com.kodilla.good.patterns.challenges.food2door;

public class DataRetriever {
    public Order data(){
        Customer customer = new Customer("Adam","Miałczyński","Wrocław, Grabiszyńska 15");
        GlutenFreeShop healthyShop = new GlutenFreeShop();
        Product product = healthyShop.getList().get(0);
        Product product2 = healthyShop.getList().get(1);
        Product product3 = healthyShop.getList().get(2);
        Item item = new Item(product,2);
        Item item2 = new Item(product2,1);
        Item item3 = new Item(product3,4);
        Order result = new Order(healthyShop,customer);
        result.getItems().add(item);
        result.getItems().add(item2);
        result.getItems().add(item3);
        return result;
    }
}
