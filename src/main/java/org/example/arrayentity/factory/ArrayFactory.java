package org.example.arrayentity.factory;

import org.example.arrayentity.entity.impl.IntArray;

public abstract class ArrayFactory {
    public abstract IntArray createArray(int[] values);
}
