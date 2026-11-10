package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArrayAverageValueSpecificationImpl implements ArraySpecification {

    private final double averageValue;
    private final BiPredicate<Double, Double> predicate;

    public ArrayAverageValueSpecificationImpl(double averageValue, BiPredicate<Double, Double> predicate) {
        this.averageValue = averageValue;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getArrayStatistics((intArray.getId())).getAverage(), averageValue);
    }


}
