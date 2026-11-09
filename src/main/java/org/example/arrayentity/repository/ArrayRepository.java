package org.example.arrayentity.repository;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.impl.IntArray;
import org.example.arrayentity.specification.ArraySpecification;

import java.util.List;

public interface ArrayRepository {

    void addArray(IntArray intArray);

    void deleteArray(int id);

    List<IntArray> findBySpecification(ArraySpecification specification);

    void sort(ArrayComparator arrayComparator);

}
