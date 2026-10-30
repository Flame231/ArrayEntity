package org.example.arrayentity.warehouse;

import org.example.arrayentity.entity.IntArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface Warehouse {

    void refreshAllValues(IntArray intArray);

    OptionalDouble getAverage();

    OptionalLong getSum();

    OptionalInt getMin();

    OptionalInt getMax();
}
