package com.kodilla.patterns2.observer.forum;

public interface Observble {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
