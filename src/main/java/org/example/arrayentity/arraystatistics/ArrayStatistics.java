package org.example.arrayentity.arraystatistics;

public class ArrayStatistics {
    private final double average;
    private final long sum;
    private final int min;
    private final int max;
    private final int size;

    public ArrayStatistics(double average, long sum, int min, int max, int size) {
        this.average = average;
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArrayStatistics{" +
                ", average=" + average +
                ", sum=" + sum +
                ", min=" + min +
                ", max=" + max +
                '}';
    }

    public double getAverage() {
        return average;
    }

    public long getSum() {
        return sum;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSize() {
        return size;
    }
}
