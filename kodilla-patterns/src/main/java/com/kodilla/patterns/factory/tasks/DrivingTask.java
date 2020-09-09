package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task{
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Task in progress: " + taskName + "; Drive to: " + where + " using: "+ using );
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
