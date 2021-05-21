package com.twsm.sort.insertion;

import java.util.function.ToIntBiFunction;

/**
 * An Insertion-Sort algorithm consist in rearrange its elements
 * like cards in a a deck. The element to be sorted is inserted in it
 * respective position after compared with the sub-array already sorted.
 * Each element of the sub-array previous sorted will be right
 * shifted from the new inserted element location.
 */
public class InsertionSort {
    public static <T extends Comparable<? super T>> void sort(T[] array, ToIntBiFunction<T, T> conditionalOrder) {
        for (int i = 1; i < array.length; i++) {
            var keyElement = array[i];
            var j = i - 1;
            while (j >= 0 && conditionalOrder.applyAsInt(array[j], keyElement) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = keyElement;
        }
    }
}
