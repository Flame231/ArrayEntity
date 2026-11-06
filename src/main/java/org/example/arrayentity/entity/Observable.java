package org.example.arrayentity.entity;

import org.example.arrayentity.observer.Observer;

public interface Observable {

    void addObserver(Observer observer);

    void remove(Observer observer);

    void notifyAllObservers();
}
