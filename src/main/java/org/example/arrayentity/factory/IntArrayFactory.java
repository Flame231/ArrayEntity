package org.example.arrayentity.factory;

import org.example.arrayentity.entity.IntArray;

public class IntArrayFactory extends ArrayFactory {
    @Override
    public IntArray createArray(int[] values) {
        return new IntArray(values);
    }
}
