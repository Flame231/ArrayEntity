package org.example.arrayentity.entity;

import org.example.arrayentity.exception.InvalidArrayException;

import java.util.Arrays;

public class IntArray {

    private int[] array;

    public void initializeArray(int[] values) {
        if (values == null) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getSize() {
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
