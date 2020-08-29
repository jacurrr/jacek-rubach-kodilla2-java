package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {

    @Test
    public void testUpdate() throws MalformedURLException {
        //Given
        QueueTasks johnTasks = new QueueTasks("John tasks");
        QueueTasks neoTasks = new QueueTasks("Neo tasks");
        QueueTasks paulTasks = new QueueTasks("Paul tasks");
        QueueTasks margaretTasks = new QueueTasks("Margaret tasks");

        Mentor jacob = new Mentor("Jakub", "Bób");
        Mentor sebastian = new Mentor("Sebastian", "Kasztan");

        johnTasks.registerObserver(jacob);
        neoTasks.registerObserver(jacob);
        paulTasks.registerObserver(jacob);
        margaretTasks.registerObserver(sebastian);

        //When
            johnTasks.addTask(new Task("Spring", new URL("https://example.com/ex1")));
            neoTasks.addTask(new Task("JDBC", new URL("https://example.com/ex2")));
            paulTasks.addTask(new Task("Patterns", new URL("https://example.com/ex3")));
            margaretTasks.addTask(new Task("Hibernate", new URL("https://example.com/ex4")));
            johnTasks.addTask(new Task("Test", new URL("https://example.com/ex5")));

        //Then
        assertEquals(4,jacob.getCountUpdate());
        assertEquals(1,sebastian.getCountUpdate());
    }

    @Test
    public void testDeleteTaskFromQueue() throws MalformedURLException {
        //Given
        QueueTasks johnTasks = new QueueTasks("John tasks");
        Mentor jacob = new Mentor("Jakub", "Bób");
        Task task = new Task("Spring", new URL("https://example.com/ex6"));
        johnTasks.registerObserver(jacob);
        johnTasks.addTask(task);
        //When
        jacob.deleteTaskFromQueue(task);
        //Then
        Assert.assertEquals(0, johnTasks.getTasks().size());
    }
}
