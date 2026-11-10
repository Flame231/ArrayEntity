package org.example.arrayentity.warehouse;

import org.example.arrayentity.arraystatistics.ArrayStatistics;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse reference;

    private final Map<Integer, ArrayStatistics> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getReference() {
        if (reference == null) {
            reference = new Warehouse();
            return reference;
        }
        return reference;
    }

    public void putArrayStatistics(Integer id, ArrayStatistics arrayStatistics) {
        map.put(id, arrayStatistics);
    }

    public ArrayStatistics getArrayStatistics(Integer id) {
        return map.get(id);
    }
}
