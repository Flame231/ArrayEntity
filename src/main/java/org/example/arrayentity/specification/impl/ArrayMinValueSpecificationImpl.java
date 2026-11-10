package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArrayMinValueSpecificationImpl implements ArraySpecification {

    private final int minValue;
    private final BiPredicate<Integer, Integer> predicate;

    public ArrayMinValueSpecificationImpl(int minValue, BiPredicate<Integer, Integer> predicate) {
        this.minValue = minValue;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getArrayStatistics((intArray.getId())).getMin(), minValue);
    }


}
