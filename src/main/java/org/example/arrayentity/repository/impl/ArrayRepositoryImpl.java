package org.example.arrayentity.repository.impl;

import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.exception.IdNotFoundException;
import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.repository.ArrayRepository;
import org.example.arrayentity.service.ArraySumService;
import org.example.arrayentity.service.impl.ArraySumServiceImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

    private static ArrayRepository refference;

    private List<IntArray> list = new ArrayList<>();

    private ArrayRepositoryImpl() {
    }

    public static ArrayRepository getArrayRepository() {
        if (refference == null) {
            refference = new ArrayRepositoryImpl();
            return refference;
        }
        return refference;
    }

    @Override
    public void addArray(IntArray intArray) {
        if (intArray == null || intArray.getSize() == 0) {
            throw new InvalidArrayException("Invalid array exception!");
        }
    }

    @Override
    public void deleteArray(int id) {
        for (IntArray array : list) {
            if (array.getId() == id) {
                list.remove(array);
            }
        }
        throw new IdNotFoundException("Array id not found!");
    }
}
