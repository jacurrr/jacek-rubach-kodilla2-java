package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        Millenials millenials = new Millenials("Piotr");
        YGeneration yGeneration = new YGeneration("Sebastian");
        ZGeneration zGeneration = new ZGeneration("Jan");
        //When
        String resultDefaultShareMillenials = millenials.sharePost("123");
        String resultDefaultShareYGeneration = yGeneration.sharePost("123");
        String resultDefaultShareZGeneration = zGeneration.sharePost("123");
        //Then
        Assert.assertEquals("Published post on Snapchat: 123",resultDefaultShareMillenials);
        Assert.assertEquals("Published post on Twitter: 123",resultDefaultShareYGeneration);
        Assert.assertEquals("Published post on Facebook: 123",resultDefaultShareZGeneration);
    }

    @Test
    public void testIndividualSharingStrategies(){
        //Given
        Millenials millenials = new Millenials("Adam");
        //When
        millenials.setSocialPublisher(new FacebookPublisher());
        String result = millenials.sharePost("123");
        //Then
        Assert.assertEquals("Published post on Facebook: 123", result);
    }
}
