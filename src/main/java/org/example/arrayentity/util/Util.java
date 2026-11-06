package org.example.arrayentity.util;

public class Util {
    private static int nextId = 1;

    public static int id() {
        return nextId;
    }

    public static void nextId() {
        nextId++;
    }
}
