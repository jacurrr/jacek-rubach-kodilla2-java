package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class QueueTasks implements ObservableQueue{
    private final List<Task> tasks = new ArrayList<>();
    private final List<ObserverMentor> mentors = new ArrayList<>();
    private final String name;

    public QueueTasks(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<ObserverMentor> getMentors() {
        return mentors;
    }

    public void addTask(final Task task){
        tasks.add(task);
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(ObserverMentor observer) {
        mentors.add(observer);
        observer.saveQueue(this);
    }

    @Override
    public void notifyObservers() {
        for (ObserverMentor observerMentor : mentors){
            observerMentor.update(this);
        }
    }

    @Override
    public void removeObserver(ObserverMentor observer) {
        mentors.remove(observer);
        observer.deleteQueue(this);
    }
}
