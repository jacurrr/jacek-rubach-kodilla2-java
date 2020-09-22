package com.kodilla.good.patterns.challenges.food2door;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price.setScale(2, RoundingMode.DOWN) +
                '}';
    }
}
