package org.example.arrayentity.entity.impl;

import org.example.arrayentity.entity.Observable;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.observer.Observer;
import org.example.arrayentity.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IntArray implements Observable {


    private int id;
    private int[] array;
    private final List<Observer> observers = new ArrayList<>();

    public IntArray(int[] values) {
        if (values == null || values.length == 0) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
        id = Util.id();
        Util.nextId();
        notifyAllObservers();
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return array.length;
    }

    public void setArray(int[] values) {
        if (values == null || values.length == 0) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
        notifyAllObservers();
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return id == intArray.id && Objects.deepEquals(array, intArray.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Arrays.hashCode(array));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IntArray { array= ").append(Arrays.toString(array)).append(" }");
        return stringBuilder.toString();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
