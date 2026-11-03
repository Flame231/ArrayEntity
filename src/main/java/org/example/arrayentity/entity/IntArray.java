package org.example.arrayentity.entity;

import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.observer.Observer;
import org.example.arrayentity.observer.impl.ObserverImpl;

import java.util.Arrays;
import java.util.Objects;

public class IntArray {

    private static int nextId = 1;

    private int id;
    private int[] array;
    private Observer observer;

    public IntArray(int[] values) {
        if (values == null || values.length == 0) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
        observer = new ObserverImpl();
        id = nextId;
        nextId++;
        observer.update(this);
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
        observer.update(this);
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

}
