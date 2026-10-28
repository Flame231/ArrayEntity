package org.example.arrayentity.factory;

import org.example.arrayentity.entity.IntArray;

public class IntArrayFactory extends ArrayFactory {
    @Override
    public IntArray createArray() {
        return new IntArray();
    }
}
