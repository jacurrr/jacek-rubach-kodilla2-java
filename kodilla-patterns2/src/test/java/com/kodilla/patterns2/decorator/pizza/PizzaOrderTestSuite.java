package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testExtraCheeseHawaiianThinCrustGetCost(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new HawaiianDecorator(theOrder);
        theOrder = new ThinCrustDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21), calculatedCost);
    }

    @Test
    public void testExtraCheeseHawaiianThinCrustGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new HawaiianDecorator(theOrder);
        theOrder = new ThinCrustDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Cheese & tomato sauce & extra cheese & pineapple & chicken & thin crust variant", description);
    }
}