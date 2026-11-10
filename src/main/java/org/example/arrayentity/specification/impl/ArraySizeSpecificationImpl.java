package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArraySizeSpecificationImpl implements ArraySpecification {

    private final int size;
    private final BiPredicate<Integer, Integer> predicate;

    public ArraySizeSpecificationImpl(int size, BiPredicate<Integer, Integer> predicate) {
        this.size = size;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getArrayStatistics((intArray.getId())).getSize(), size);
    }


}
