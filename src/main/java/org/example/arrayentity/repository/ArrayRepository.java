package org.example.arrayentity.repository;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.ArrayNotFoundException;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.specification.impl.ArrayIdSpecificationImpl;
import org.example.arrayentity.specification.impl.ArraySumSpecificationImpl;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepository {

    private static ArrayRepository reference;

    private List<IntArray> list = new ArrayList<>();

    private ArrayRepository() {
    }

    public static ArrayRepository getReference() {
        if (reference == null) {
            reference = new ArrayRepository();
            return reference;
        }
        return reference;
    }

    public void addArray(IntArray intArray) {
        if (intArray == null || intArray.getSize() == 0) {
            throw new InvalidArrayException("Invalid array exception!");
        }
        list.add(intArray);
    }

    public void deleteArray(int id) {
        for (IntArray array : list) {
            if (array.getId() == id) {
                list.remove(array);
                return;
            }
        }
        throw new ArrayNotFoundException("Array id not found!");
    }

    public IntArray findById(int id) {
        ArraySpecification arrayIdSpecification = new ArrayIdSpecificationImpl(id);
        for (IntArray array : list) {
            if (arrayIdSpecification.matches(array)) {
                return array;
            }
        }
        throw new ArrayNotFoundException(String.format("Array with id '%s' not found!", id));
    }

    public List<IntArray> findWhereSumIs(long sum) {
        ArraySpecification arraySumSpecification = new ArraySumSpecificationImpl(sum);
        List<IntArray> arrayList = new ArrayList<>();
        for (IntArray array : list) {
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
        list.sort(arrayComparator);
    }
}
