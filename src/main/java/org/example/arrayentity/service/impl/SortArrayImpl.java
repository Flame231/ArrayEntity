package org.example.arrayentity.service.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.service.SortArray;

public class SortArrayImpl implements SortArray {
    @Override
    public void bubleSort(IntArray intArray) {
        int[] array = intArray.getArray();
        boolean changed = false;
        do {
            changed = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
            }
        }
        while (changed);
        intArray.setArray(array);
    }

    @Override
    public void selectionSort(IntArray intArray) {
        int[] array = intArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minValueIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minValueIndex = j;
                }
            }
            int temp = array[i];
            array[i] = minValue;
            array[minValueIndex] = temp;
        }
        intArray.setArray(array);
    }
}
