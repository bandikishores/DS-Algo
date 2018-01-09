package com.bandi.util;

import java.util.Arrays;

public class Utils {

    public static <T> void printArray(T[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            System.out.println(objectArray);
        } else {
            Arrays.stream(objectArray).forEach(System.out::println);
        }
    }

    public static void printArray(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            System.out.println(intArray);
        } else {
            Arrays.stream(intArray).forEach(System.out::println);
        }
    }
}
