package org.example.arrayentity.specification.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.specification.ArraySpecification;

public class ArrayIdSpecificationImpl implements ArraySpecification {

    private final int id;

    public ArrayIdSpecificationImpl(int id) {
        this.id = id;
    }

    @Override
    public boolean matches(IntArray intArray) {
        return intArray.getId() == id;
    }
}
