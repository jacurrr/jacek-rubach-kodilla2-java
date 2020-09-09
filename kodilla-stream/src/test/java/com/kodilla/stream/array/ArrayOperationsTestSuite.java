package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] numbers= new int[10];
        numbers[0]=2;
        numbers[1]=3;
        numbers[2]=2;
        numbers[3]=3;
        numbers[4]=2;
        numbers[5]=3;
        numbers[6]=2;
        numbers[7]=3;
        numbers[8]=2;
        numbers[9]=3;
        //When
        double result = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(2.5,result,0);
    }
}
