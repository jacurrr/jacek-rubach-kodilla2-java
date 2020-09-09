package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void  beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(3);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(1, shapeCollector.getSize());
    }

    @Test
    public void testRemoveFigureNotExisting(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(4);
        //When
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(4);
        shapeCollector.addFigure(triangle);
        //When
        boolean result = shapeCollector.removeFigure(triangle);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(3,4,5.0);
        shapeCollector.addFigure(triangle);
        //When
        Shape retrievedShape = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(triangle, retrievedShape);
    }

    @Test
    public void testGetFigureNegativeIndex(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape retrievedShape = shapeCollector.getFigure(-1);
        //Then
        Assert.assertNull(retrievedShape);
    }

    @Test
    public void testGetFigureOutOfRange(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape retrievedShape = shapeCollector.getFigure(5);
        //Then
        Assert.assertNull(retrievedShape);
    }

    @Test
    public void testShowFigureNotExisting(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        String result = shapeCollector.showFigure(0);
        //Then
        Assert.assertEquals(null, result);
    }

    @Test
    public void testShowFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(3,2);
        shapeCollector.addFigure(triangle);
        //When
        String result = shapeCollector.showFigure(0);
        //Then
        Assert.assertEquals("Shape: " + triangle.getShapeName() + "Field: " + triangle.getField(), result);
    }
}