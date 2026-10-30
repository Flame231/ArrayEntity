package org.example.arrayentity.warehouse.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;
import org.example.arrayentity.service.ExtremumService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;
import org.example.arrayentity.service.impl.AverageValueServiceImpl;
import org.example.arrayentity.service.impl.ExtremumServiceImpl;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class WarehouseImpl implements Warehouse {

    private OptionalDouble average;
    private OptionalLong sum;
    private OptionalInt min;
    private OptionalInt max;

    private AverageValueService averageValueService = new AverageValueServiceImpl();
    private ArraySumService arraySumService = new ArraySumServiceImpl();
    private ExtremumService extremumService = new ExtremumServiceImpl();

    @Override
    public void refreshAllValues(IntArray intArray) {
        average = averageValueService.calculateAverageValue(intArray);
        sum = arraySumService.calculateSum(intArray);
        min = extremumService.findMinValue(intArray);
        max = extremumService.findMaxValue(intArray);
    }

    @Override
    public OptionalDouble getAverage() {
        return average;
    }

    @Override
    public OptionalLong getSum() {
        return sum;
    }

    @Override
    public OptionalInt getMin() {
        return min;
    }

    @Override
    public OptionalInt getMax() {
        return max;
    }
}
