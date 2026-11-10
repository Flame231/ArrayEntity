package org.example.arrayentity.entity.impl;

import org.example.arrayentity.entity.Observable;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.observer.ArrayObserver;
import org.example.arrayentity.observer.impl.ArrayObserverImpl;
import org.example.arrayentity.util.ArrayIdGenerator;

import java.util.Arrays;
import java.util.Objects;

public class IntArray implements Observable {


    private final int id;
    private int[] array;
    private ArrayObserver arrayObserver = new ArrayObserverImpl();

    public IntArray(int[] values) {
        if (values == null || values.length == 0) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
        id = ArrayIdGenerator.nextId();
        notifyObserver();
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
        notifyObserver();
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
    public void attach(ArrayObserver arrayObserver) {
        this.arrayObserver = arrayObserver;
        notifyObserver();
    }

    @Override
    public void detach() {
        this.arrayObserver = null;
    }

    @Override
    public void notifyObserver() {
        if (arrayObserver != null) {
            arrayObserver.update(this);
        }
    }
}
