package com.kodilla.good.patterns.challenges.orderService;

public class OrderDto {
    public User user;
    public boolean isSell;
    public OrderDto(final User user, final boolean isSell) {
        this.user = user;
        this.isSell = isSell;
    }

}
