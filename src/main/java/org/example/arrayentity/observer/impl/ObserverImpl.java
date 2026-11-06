package org.example.arrayentity.observer.impl;

import org.example.arrayentity.arraystatistics.ArrayStatistics;
import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.observer.Observer;
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

public class ObserverImpl implements Observer {

    private final ArraySumService arraySumService = new ArraySumServiceImpl();
    private final AverageValueService averageValueService = new AverageValueServiceImpl();
    private final ExtremumService extremumService = new ExtremumServiceImpl();

    @Override
    public void update(IntArray intArray) {
        OptionalLong sum = arraySumService.calculateSum(intArray);
        OptionalDouble averageValue = averageValueService.calculateAverageValue(intArray);
        OptionalInt max = extremumService.findMaxValue(intArray);
        OptionalInt min = extremumService.findMinValue(intArray);
        Warehouse.getReference().addArrayStatistics(intArray.getId(), new ArrayStatistics(averageValue, sum, min, max));
    }
}
