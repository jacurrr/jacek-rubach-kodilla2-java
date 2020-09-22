package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retriever() {
        User user = new User("jonny", "John Smith", LocalDate.of(1992, 2, 2));
        LocalDateTime time = LocalDateTime.now();
        MethodDeliver methodDeliver = new MethodDeliver("Inpost", "Bierutowska 24, Worcław", "Długa 52, Wrocław", 10.20);
        Product product = new Product("Uchwyt", 20.52);
        return new OrderRequest(user, time, methodDeliver, product);
    }
}
