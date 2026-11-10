package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArrayMaxValueSpecificationImpl implements ArraySpecification {

    private final int maxValue;
    private final BiPredicate<Integer, Integer> predicate;

    public ArrayMaxValueSpecificationImpl(int maxValue, BiPredicate<Integer, Integer> predicate) {
        this.maxValue = maxValue;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getArrayStatistics((intArray.getId())).getMax(), maxValue);
    }

}
