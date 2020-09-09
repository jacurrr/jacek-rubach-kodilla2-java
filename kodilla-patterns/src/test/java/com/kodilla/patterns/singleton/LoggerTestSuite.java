package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog(){
        //Given
        Logger.getInstance().log("test12345");
        //When
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("test12345", result);
    }

    @Test
    public void testGetEmptyLog(){
        //Given
        //When
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("", result);
    }
}