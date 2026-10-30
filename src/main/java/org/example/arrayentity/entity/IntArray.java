package org.example.arrayentity.entity;

import org.example.arrayentity.exception.InvalidArrayException;
import org.example.arrayentity.warehouse.Warehouse;
import org.example.arrayentity.warehouse.impl.WarehouseImpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class IntArray {

    private Warehouse warehouse = new WarehouseImpl();
    private int id;

    private int[] array;

    public void initializeArray(int[] values) {
        if (values == null) {
            throw new InvalidArrayException("values are invalid!");
        }
        this.array = Arrays.copyOf(values, values.length);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return id == intArray.id && Objects.deepEquals(array, intArray.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Arrays.hashCode(array));
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getSize() {
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
