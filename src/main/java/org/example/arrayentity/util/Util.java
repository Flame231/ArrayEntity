package org.example.arrayentity.util;

public class Util {
    private static int id = 0;

    public static int id() {
        return id;
    }

    public static void nextId() {
        id++;
    }
}
