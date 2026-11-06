package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

public class ArraySumSpecificationImpl implements ArraySpecification {

    private final long sum;

    public ArraySumSpecificationImpl(long sum) {
        this.sum = sum;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return sum == Warehouse.getReference().getArrayStatisticsById(intArray.getId()).getSum().getAsLong();
    }
}
