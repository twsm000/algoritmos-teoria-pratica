package com.twsm.sort.merge;

import java.util.Arrays;
import java.util.function.ToIntBiFunction;

public class MergeSort {
    public static <T extends Comparable<? super T>> void sort(T[] array, ToIntBiFunction<T, T> conditionalOrder) {
        if (array.length < 2) {
            return;
        }

        int start = 0;
        int end = array.length - 1;
        mergeSort(array, start, end, conditionalOrder);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] array,
                                                                    int start,
                                                                    int end,
                                                                    ToIntBiFunction<T, T> conditionalOrder) {
        if (start == end) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(array, start, middle, conditionalOrder);
        mergeSort(array, middle + 1, end, conditionalOrder);

        merge(array, start, middle, end, conditionalOrder);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array,
                                                                int start,
                                                                int middle,
                                                                int end,
                                                                ToIntBiFunction<T, T> conditionalOrder) {

        var tmp = Arrays.copyOfRange(array, start, middle + 1);
        int current = start;
        int i = 0;
        int j = middle + 1;

        while (i < tmp.length && j <= end) {
            if (conditionalOrder.applyAsInt(tmp[i], array[j]) < 0) {
                array[current++] = tmp[i++];
            } else {
                array[current++] = array[j++];
            }
        }

        while (i < tmp.length) {
            array[current++] = tmp[i++];
        }
    }
}
