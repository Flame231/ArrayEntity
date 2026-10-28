package org.example.arrayentity.factory;

import org.example.arrayentity.entity.IntArray;

public abstract class ArrayFactory {

    abstract IntArray createArray();

    public IntArray initializeArray(int[] data) {
        IntArray array = createArray();
        array.initializeArray(data);
        return array;
    }

}
