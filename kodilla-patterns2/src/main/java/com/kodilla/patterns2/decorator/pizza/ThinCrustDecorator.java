package com.kodilla.patterns2.decorator.pizza;

public class ThinCrustDecorator extends AbstractPizzaOrderDecorator{
    public ThinCrustDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" & thin crust variant";
    }
}
