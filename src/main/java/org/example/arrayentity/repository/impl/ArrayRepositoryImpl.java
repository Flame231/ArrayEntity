package org.example.arrayentity.repository.impl;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.exception.ArrayNotFoundException;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.repository.ArrayRepository;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.specification.impl.ArrayIdSpecificationImpl;
import org.example.arrayentity.specification.impl.ArraySumSpecificationImpl;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

    private static ArrayRepositoryImpl reference;

    private final List<IntArray> arrays = new ArrayList<>();

    private ArrayRepositoryImpl() {
    }

    public static ArrayRepositoryImpl getReference() {
        if (reference == null) {
            reference = new ArrayRepositoryImpl();
            return reference;
        }
        return reference;
    }

    @Override
    public void addArray(IntArray intArray) {
        if (intArray == null || intArray.getSize() == 0) {
            throw new InvalidArrayException("Invalid array exception!");
        }
        arrays.add(intArray);
    }

    @Override
    public void deleteArray(int id) {
        for (IntArray array : arrays) {
            if (array.getId() == id) {
                arrays.remove(array);
                return;
            }
        }
        throw new ArrayNotFoundException("Array id not found!");
    }

    @Override
    public List<IntArray> findBySpecification(ArraySpecification specification) {
        List<IntArray> list = new ArrayList<>();
        for (IntArray array : arrays) {
            if (specification.matches(array)) {
                list.add(array);
            }
        }
        if (list.isEmpty()) {
            throw new ArrayNotFoundException("Arrays are not found!");
        }
        return list;
    }

    @Override
    public void sort(ArrayComparator arrayComparator) {
        arrays.sort(arrayComparator);
    }
}
