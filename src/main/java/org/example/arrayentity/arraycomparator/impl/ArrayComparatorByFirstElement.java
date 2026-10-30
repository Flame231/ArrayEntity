package org.example.arrayentity.arraycomparator.impl;

import org.example.arrayentity.arraycomparator.ArrayComparator;
import org.example.arrayentity.entity.IntArray;

public class ArrayComparatorByFirstElement implements ArrayComparator {

    @Override
    public int compare(IntArray o1, IntArray o2) {
        int o1First = o1.getArray()[0];
        int o2First = o2.getArray()[0];
        return o1First > o2First ? 1 : (o1First < o2First ? -1 : 0);
    }
}
