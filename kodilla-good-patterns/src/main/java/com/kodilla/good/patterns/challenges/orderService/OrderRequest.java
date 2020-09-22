package com.kodilla.good.patterns.challenges.orderService;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime dateOrder;
    private MethodDeliver methodDeliver;
    private Product product;

    public OrderRequest(User user, LocalDateTime dateOrder, MethodDeliver methodDeliver, Product product) {
        this.user = user;
        this.dateOrder = dateOrder;
        this.methodDeliver = methodDeliver;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public MethodDeliver getMethodDeliver() {
        return methodDeliver;
    }

    public Product getProduct() {
        return product;
    }
}
