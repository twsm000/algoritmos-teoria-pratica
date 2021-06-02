package com.twsm.sort.merge;

import java.lang.reflect.Array;
import java.util.function.ToIntBiFunction;

public class MergeSort {
    public static <T extends Comparable<? super T>> void sort(T[] array, ToIntBiFunction<T, T> conditionalOrder) {
        if (array.length < 2) {
            return;
        }

        int start = 0;
        int end = array.length - 1;

        var tmp = newHalfArray(array);
        mergeSort(array, tmp, start, end, conditionalOrder);
    }

    private static <T extends Comparable<? super T>> T[] newHalfArray(T[] array) {
        return (T[]) Array.newInstance(array.getClass().getComponentType(), array.length / 2);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] array,
                                                                    T[] tmp,
                                                                    int start,
                                                                    int end,
                                                                    ToIntBiFunction<T, T> conditionalOrder) {
        if (start == end) {
            return;
        }

        int middle = (start + end) / 2 + 1;
        mergeSort(array, tmp, start, middle - 1, conditionalOrder);
        mergeSort(array, tmp, middle, end, conditionalOrder);

        merge(array, tmp, start, middle, end, conditionalOrder);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array,
                                                                T[] tmp,
                                                                int start,
                                                                int middle,
                                                                int end,
                                                                ToIntBiFunction<T, T> conditionalOrder) {

        int tmpSize = middle - start;
        System.arraycopy(array, start, tmp, 0, tmpSize);
        int current = start;
        int firstHalf = 0;
        int secondHalf = middle;

        while (firstHalf < tmpSize && secondHalf <= end) {
            if (conditionalOrder.applyAsInt(tmp[firstHalf], array[secondHalf]) < 0) {
                array[current++] = tmp[firstHalf++];
            } else {
                array[current++] = array[secondHalf++];
            }
        }

        while (firstHalf < tmpSize) {
            array[current++] = tmp[firstHalf++];
        }
    }
}
