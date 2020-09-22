package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;

public class HolderOrderService implements OrderService {

    @Override
    public boolean order(User user, LocalDateTime date, MethodDeliver methodDeliver, Product product) {
        return true;
    }
}
