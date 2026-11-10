package org.example.arrayentity.entity;

import org.example.arrayentity.observer.ArrayObserver;

public interface Observable {

    void attach(ArrayObserver arrayObserver);

    void detach();

    void notifyObserver();
}
