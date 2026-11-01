package org.example.arrayentity.warehouse;

import org.example.arrayentity.arraystatistics.ArrayStatistics;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse reference;

    private Map<Integer, ArrayStatistics> map = new HashMap<Integer, ArrayStatistics>();

    private Warehouse() {
    }

    public static Warehouse getReference() {
        if (reference == null) {
            reference = new Warehouse();
            return reference;
        }
        return reference;
    }

    public ArrayStatistics getArrayStatisticsById(int id) {
        return map.get(id);
    }

    public void addArrayStatistics(Integer id,ArrayStatistics arrayStatistics){
        map.put(id,arrayStatistics);
    }

}
