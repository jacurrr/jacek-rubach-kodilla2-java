package com.kodilla.good.patterns.challenges.orderService;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retriever();
        ProductOrderService productOrderService = new ProductOrderService(new SMSService(), new HolderOrderService(), new HolderRepositoryService());
        productOrderService.process(orderRequest);
    }
}
