package org.example.arrayentity.arraycomparator.impl;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.IntArray;

public class ArrayComparatorById implements ArrayComparator {

    @Override
    public int compare(IntArray o1, IntArray o2) {
        return o1.getId() > o2.getId() ? 1 : (o1.getId() < o2.getId() ? -1 : 0);
    }
}
