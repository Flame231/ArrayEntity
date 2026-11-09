package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

import java.util.function.BiPredicate;

public class ArrayIdSpecificationImpl implements ArraySpecification {

    private final int id;
    private final BiPredicate<Long, Integer> predicate;

    public ArrayIdSpecificationImpl(int id, BiPredicate<Long, Integer> predicate) {
        this.id = id;
        this.predicate = predicate;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return predicate.test(Warehouse.getReference().getList().get(intArray.getId()).getSum().orElseThrow(), id);
    }


}
