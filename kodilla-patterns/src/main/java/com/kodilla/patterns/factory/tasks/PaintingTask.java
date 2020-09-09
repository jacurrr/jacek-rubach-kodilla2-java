package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isTaskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Task in progress: " + taskName + "; paint " + whatToPaint + " in "+ color );
        isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
