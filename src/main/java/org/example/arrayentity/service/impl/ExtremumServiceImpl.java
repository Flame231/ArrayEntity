package org.example.arrayentity.service.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.service.ExtremumService;

import java.util.OptionalInt;

public class ExtremumServiceImpl implements ExtremumService {
    @Override
    public OptionalInt findMaxValue(IntArray array) {
        if (array == null || array.getSize() == 0) {
            throw new InvalidArrayException("array is invalid!");
        }
        int[] arr = array.getArray();
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt findMinValue(IntArray array) {
        if  (array == null || array.getSize() == 0)  {
            throw new InvalidArrayException("array is invalid!");
        }
        int[] arr = array.getArray();
        int min = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return OptionalInt.of(min);
    }
}
