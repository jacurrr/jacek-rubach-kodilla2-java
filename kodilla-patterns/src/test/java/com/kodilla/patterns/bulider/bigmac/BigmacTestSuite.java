package com.kodilla.patterns.bulider.bigmac;

import com.kodilla.patterns.builder.bigmac.Bigmac;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .bun("with sesame")
                .burgers(3)
                .ingredient("onion")
                .ingredient("cheese")
                .ingredient("mushrooms")
                .ingredient("lettuce")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String bun = bigmac.getBun();
        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals(3, howManyBurgers);
        Assert.assertEquals("with sesame", bun);
    }
}
