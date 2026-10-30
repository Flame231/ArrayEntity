package org.example.arrayentity.arraycomparator.impl;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.IntArray;

public class ArrayComparatorBySize implements ArrayComparator {

    @Override
    public int compare(IntArray o1, IntArray o2) {
        int o1Size = o1.getArray().length;
        int o2Size = o2.getArray().length;
        return o1Size > o2Size ? 1 : (o1Size < o2Size ? -1 : 0);
    }
}
