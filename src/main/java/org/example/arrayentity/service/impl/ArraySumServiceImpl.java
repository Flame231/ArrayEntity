package org.example.arrayentity.service.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.service.ArraySumService;

import java.util.OptionalInt;

public class ArraySumServiceImpl implements ArraySumService {
    @Override
    public OptionalInt calculateSum(IntArray array) {
        if (array == null || array.getSize() == 0) {
            throw new InvalidArrayException("array is invalid!");
        }
        int sum = 0;
        for (int i : array.getArray()) {
            sum += i;
        }
        return OptionalInt.of(sum);
    }
}
