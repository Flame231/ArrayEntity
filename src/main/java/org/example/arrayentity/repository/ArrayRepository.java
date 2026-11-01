package org.example.arrayentity.repository;

import org.example.arrayentity.entity.IntArray;

import java.util.List;

public interface ArrayRepository {

    void addArray(IntArray intArray);

    void deleteArray(int id);
}
