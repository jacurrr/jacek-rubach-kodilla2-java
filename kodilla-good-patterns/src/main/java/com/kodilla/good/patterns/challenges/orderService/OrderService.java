package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;

public interface OrderService {
    boolean order(User user, LocalDateTime date, MethodDeliver methodDeliver, Product product);
}
