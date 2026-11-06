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

    public void addArray(IntArray intArray) {
        if (intArray == null || intArray.getSize() == 0) {
            throw new InvalidArrayException("Invalid array exception!");
        }
        arrays.add(intArray);
    }

    public void deleteArray(int id) {
        for (IntArray array : arrays) {
            if (array.getId() == id) {
                arrays.remove(array);
                return;
            }
        }
        throw new ArrayNotFoundException("Array id not found!");
    }

    public IntArray findBySpecification(ArraySpecification specification) {
        for (IntArray array : arrays) {
            if (specification.matches(array)) {
                return array;
            }
        }
        throw new ArrayNotFoundException(String.format("Array with id '%s' not found!", id));
    }

    public List<IntArray> findWhereSumIs(long sum) {
        ArraySpecification arraySumSpecification = new ArraySumSpecificationImpl(sum);
        List<IntArray> arrayList = new ArrayList<>();
        for (IntArray array : arrays) {
            if (arraySumSpecification.matches(array)) {
                arrayList.add(array);
            }
        }
        if (arrayList.isEmpty()) {
            throw new ArrayNotFoundException(String.format("Array with sum '%s' not found!", sum));
        }
        return arrayList;
    }

    public void sort(ArrayComparator arrayComparator) {
        arrays.sort(arrayComparator);
    }
}
