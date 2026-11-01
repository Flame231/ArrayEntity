package org.example.arrayentity.specification.impl;

import org.example.arrayentity.arraystatistics.ArrayStatistics;
import org.example.arrayentity.entity.IntArray;
import org.example.arrayentity.specification.ArraySpecification;
import org.example.arrayentity.warehouse.Warehouse;

public class ArraySumSpecificationImpl implements ArraySpecification {

    private ArrayStatistics arrayStatistics;

    @Override
    public boolean matches(IntArray intArray) {
        return this.arrayStatistics.getSum() == Warehouse.getReference().getArrayStatisticsById(intArray.getId()).getSum();
    }
}
