package com.kodilla.patterns2.observer.homework;

public interface ObservableQueue {
    void registerObserver(ObserverMentor observer);
    void notifyObservers();
    void removeObserver(ObserverMentor observer);
}
