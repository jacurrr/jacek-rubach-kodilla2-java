package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, LocalDateTime date, MethodDeliver methodDeliver, Product product);
}
