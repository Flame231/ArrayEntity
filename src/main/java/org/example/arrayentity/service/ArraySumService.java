package org.example.arrayentity.service;

import org.example.arrayentity.entity.IntArray;

import java.util.OptionalLong;

public interface ArraySumService {
    OptionalLong calculateSum(IntArray intArray);
}
