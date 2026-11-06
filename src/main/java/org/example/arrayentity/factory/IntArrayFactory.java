package org.example.arrayentity.factory;

import org.example.arrayentity.entity.impl.IntArray;

public class IntArrayFactory extends ArrayFactory {
    @Override
    public IntArray createArray(int[] values) {
        return new IntArray(values);
    }
}
