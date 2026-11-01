package org.example.arrayentity.factory;

import org.example.arrayentity.entity.IntArray;

public abstract class ArrayFactory {
    abstract IntArray createArray(int[] values);
}
