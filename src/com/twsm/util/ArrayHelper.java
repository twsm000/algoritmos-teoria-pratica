package com.twsm.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayHelper {
    public static Integer[] generateIntegers(int size, int minValue, int maxValue) {
        return new Random().ints(size, minValue, maxValue)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static <T> void display(T[] array) {
        System.out.println(Arrays.stream(array)
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
    }
}
