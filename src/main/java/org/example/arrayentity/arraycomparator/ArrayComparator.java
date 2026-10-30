package org.example.arrayentity.arraycomparator;

import org.example.arrayentity.entity.IntArray;

import java.util.Comparator;

public interface ArrayComparator extends Comparator<IntArray> {

    @Override
    int compare(IntArray o1, IntArray o2);
}
