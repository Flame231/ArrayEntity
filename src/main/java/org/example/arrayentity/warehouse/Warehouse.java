package org.example.arrayentity.warehouse;

import org.example.arrayentity.arraystatistics.ArrayStatistics;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private static Warehouse reference;

    private final List<ArrayStatistics> list = new ArrayList<>();

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
        return list.get(id);
    }

    public void addArrayStatistics(ArrayStatistics arrayStatistics) {
        list.add(arrayStatistics);
    }

    public void updateArrayStatistics(ArrayStatistics arrayStatistics) {
        list.set(arrayStatistics.getId(), arrayStatistics);
    }

    public List<ArrayStatistics> getList() {
        return list;
    }
}
