package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mentor implements ObserverMentor{
    private String fistName;
    private String lastName;
    private int countUpdate;
    private List<QueueTasks> observerQueues= new ArrayList<>();

    public Mentor(String fistName, String lastName){
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCountUpdate() {
        return countUpdate;
    }

    @Override
    public void update(QueueTasks queueTasks) {
        System.out.println(fistName + ' ' + lastName + ": New task to check " + queueTasks.getName()
                + " (total: " + queueTasks.getTasks().size() + "tasks):");
        for (Task task : queueTasks.getTasks()){
            System.out.println('\t' + task.toString());
        }
        countUpdate++;
    }

    @Override
    public void saveQueue(QueueTasks queueTasks) {
        observerQueues.add(queueTasks);
    }

    @Override
    public void deleteQueue(QueueTasks queueTasks) {
        observerQueues.remove(queueTasks);
    }

    public void printTaskToCheck(){
        for (QueueTasks queueTasks: observerQueues){
            boolean empty = true;
            System.out.println(queueTasks.getName()+':');
            for (Task task : queueTasks.getTasks()){
                System.out.println(task);
                empty = false;
            }
            if (empty) System.out.println("No tasks to check");
        }
    }

    public List<Task> getTaskToCheck(){
        List<Task> tasks = new ArrayList<>();
        for (QueueTasks queueTasks : observerQueues){
            tasks.addAll(queueTasks.getTasks());
        }
        return tasks;
    }

    public boolean deleteTaskFromQueue(Task task){
        for (QueueTasks observerQueue : observerQueues) {
            if (observerQueue.getTasks().remove(task)) {
                return true;
            }
        }
        return false;
    }
}
