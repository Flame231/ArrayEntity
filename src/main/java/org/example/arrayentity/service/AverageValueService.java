package org.example.arrayentity.service;

import org.example.arrayentity.entity.IntArray;

import java.util.OptionalDouble;

public interface AverageValueService {
    OptionalDouble calculateAverageValue(IntArray array);
}
