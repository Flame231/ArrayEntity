package org.example.arrayentity.service;

import org.example.arrayentity.entity.IntArray;

import java.util.OptionalInt;

public interface ExtremumService {
    OptionalInt findMaxValue(IntArray array);

    OptionalInt findMinValue(IntArray array);
}
