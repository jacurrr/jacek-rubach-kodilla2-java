package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING);
        drivingTask.executeTask();
        boolean result = drivingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Travel", drivingTask.getTaskName());
        Assert.assertTrue(result);
    }

    @Test
    public void testFactoryPaintingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING);
        paintingTask.executeTask();
        boolean result = paintingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Kitchen painting", paintingTask.getTaskName());
        Assert.assertTrue(result);
    }

    @Test
    public void testFactoryShoppingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
        boolean result = shoppingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Everyday shopping", shoppingTask.getTaskName());
        Assert.assertTrue(result);
    }

    @Test
    public  void testTaskBeforeExecute(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING);
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING);
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING);
        //Then
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertFalse(drivingTask.isTaskExecuted());
    }
}
