package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;

public class HolderRepositoryService implements OrderRepository {
    @Override
    public void createOrder(User user, LocalDateTime date, MethodDeliver methodDeliver, Product product) {
        System.out.println(user + " zamówił: " + product + " " + date.toString() + " ,wybrana metoda dostawy:" + methodDeliver.getName());
    }
}
