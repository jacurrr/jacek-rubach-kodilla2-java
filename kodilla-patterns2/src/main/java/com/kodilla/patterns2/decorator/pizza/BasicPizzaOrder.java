package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public String getDescription() {
        return "Cheese & tomato sauce";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }
}
