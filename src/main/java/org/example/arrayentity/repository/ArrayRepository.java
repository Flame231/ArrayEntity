package org.example.arrayentity.repository;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.impl.IntArray;

import java.util.List;

public interface ArrayRepository {

    public void addArray(IntArray intArray);

    public void deleteArray(int id);

    public List<IntArray> findWhereSumIs(long sum);

    public void sort(ArrayComparator arrayComparator);

}
