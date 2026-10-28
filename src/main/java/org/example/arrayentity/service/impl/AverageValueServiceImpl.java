package org.example.arrayentity.service.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class AverageValueServiceImpl implements AverageValueService {

    private static final ArraySumService arraySumService = new ArraySumServiceImpl();

    @Override
    public OptionalDouble calculateAverageValue(IntArray array) {
        OptionalInt sum = arraySumService.calculateSum(array);
        double doubleSum = (double) arraySumService.calculateSum(array).getAsInt();
        return OptionalDouble.of(doubleSum / array.getSize());
    }
}
