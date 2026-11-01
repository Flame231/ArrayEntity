package org.example.arrayentity.arraystatistics;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayStatistics {

    private OptionalDouble average;
    private OptionalLong sum;
    private OptionalInt min;
    private OptionalInt max;

    public ArrayStatistics(OptionalDouble average, OptionalLong sum, OptionalInt min, OptionalInt max) {
        this.average = average;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }

    public OptionalDouble getAverage() {
        return average;
    }

    public OptionalLong getSum() {
        return sum;
    }

    public OptionalInt getMin() {
        return min;
    }

    public OptionalInt getMax() {
        return max;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    public void setSum(OptionalLong sum) {
        this.sum = sum;
    }

    public void setMin(OptionalInt min) {
        this.min = min;
    }

    public void setMax(OptionalInt max) {
        this.max = max;
    }
}
