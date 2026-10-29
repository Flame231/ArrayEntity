package org.example.arrayentity.service.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.service.ArraySumService;

import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArraySumServiceImpl implements ArraySumService {
    @Override
    public OptionalLong calculateSum(IntArray array) {
        if (array == null || array.getSize() == 0) {
            throw new InvalidArrayException("array is invalid!");
        }
        long sum = 0;
        for (int i : array.getArray()) {
            sum += i;
        }
        return OptionalLong.of(sum);
    }
}
