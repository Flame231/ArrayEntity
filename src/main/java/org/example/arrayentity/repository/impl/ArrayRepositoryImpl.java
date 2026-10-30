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

    private List<IntArray> list = new ArrayList<>();

    @Override
    public IntArray findById(int id) {
        for (IntArray array : list) {
            if (array.getId() == id) {
                return array;
            }
        }
        return null;
    }

    @Override
    public void addArray(IntArray intArray) {
        if (intArray == null || intArray.getSize() == 0) {
            throw new InvalidArrayException("Invalid array exception!");
        }
    }

    @Override
    public void deleteArrayById(int id) {
        for (IntArray array : list) {
            if (array.getId() == id) {
                list.remove(array);
            }
        }
        throw new IdNotFoundException("Array id not found!");
    }

    @Override
    public List<IntArray> findAllWhereSumIsBiggerThen(long sum) {
        ArraySumService arraySumService = new ArraySumServiceImpl();
        List<IntArray> arrayList = new ArrayList<>();
        for (IntArray array : list) {
            if (sum < arraySumService.calculateSum(array).getAsLong()) {
                arrayList.add(array);
            }
        }
        return arrayList;
    }
}
