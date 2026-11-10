package org.example.arrayentity.observer.impl;

import org.example.arrayentity.arraystatistics.ArrayStatistics;
import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.observer.ArrayObserver;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.AverageValueService;
import org.example.arrayentity.service.ExtremumService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;
import org.example.arrayentity.service.impl.AverageValueServiceImpl;
import org.example.arrayentity.service.impl.ExtremumServiceImpl;
import org.example.arrayentity.warehouse.Warehouse;

public class ArrayObserverImpl implements ArrayObserver {

    private final ArraySumService arraySumService = new ArraySumServiceImpl();
    private final AverageValueService averageValueService = new AverageValueServiceImpl();
    private final ExtremumService extremumService = new ExtremumServiceImpl();

    @Override
    public void update(IntArray intArray) {
        long sum = arraySumService.calculateSum(intArray).orElseThrow();
        double averageValue = averageValueService.calculateAverageValue(intArray).orElseThrow();
        int max = extremumService.findMaxValue(intArray).orElseThrow();
        int min = extremumService.findMinValue(intArray).orElseThrow();
        Warehouse.getReference().putArrayStatistics(intArray.getId(), new ArrayStatistics(averageValue, sum, min, max, intArray.getSize()));
    }
}
