package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        isTaskExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Task in progress: " + taskName + "; buy: " + quantity + "*"+ whatToBuy );
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
