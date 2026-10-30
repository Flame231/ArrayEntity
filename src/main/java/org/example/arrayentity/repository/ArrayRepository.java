package org.example.arrayentity.repository;

import org.example.arrayentity.entity.IntArray;

import java.util.List;

public interface ArrayRepository {

    IntArray findById(int id);

    void addArray(IntArray intArray);

    void deleteArrayById(int id);

    List<IntArray> findAllWhereSumIsBiggerThen(long sum);
}
