package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList<Integer>();
        //When
        ArrayList<Integer> result = exterminator.exterminate(list);
        System.out.println("Testing:" + result);
        //Then
        Assert.assertEquals(list, result);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        ArrayList<Integer> listOdd = new ArrayList<Integer>();
        listOdd.add(2);
        listOdd.add(4);
        listOdd.add(6);
        listOdd.add(8);
        listOdd.add(10);
        //When
        ArrayList<Integer> result = exterminator.exterminate(list);
        System.out.println("Testing:" + result);
        //Then
        Assert.assertEquals(listOdd, result);
    }
}
