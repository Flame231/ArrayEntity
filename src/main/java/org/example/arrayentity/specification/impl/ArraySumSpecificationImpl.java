package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArraySumSpecificationImpl implements ArraySpecification {

    private final long sum;
    private final BiPredicate<Long, Long> predicate;

    public ArraySumSpecificationImpl(long sum, BiPredicate<Long, Long> predicate) {
        this.sum = sum;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getArrayStatistics((intArray.getId())).getSum(), sum);
    }
}
