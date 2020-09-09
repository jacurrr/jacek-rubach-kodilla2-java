package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskClass){
        switch (taskClass){
            case DRIVING:
                return new DrivingTask("Travel","Wroclav","Car");
            case PAINTING:
                return new PaintingTask("Kitchen painting","White","Wall");
            case SHOPPING:
                return new ShoppingTask("Everyday shopping","Bread",1);
            default:
                return null;
        }
    }
}
