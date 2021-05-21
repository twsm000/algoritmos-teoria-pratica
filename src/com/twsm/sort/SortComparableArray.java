package com.twsm.sort;

import java.util.function.ToIntBiFunction;

@FunctionalInterface
public interface SortComparableArray {
    <T extends Comparable<? super T>> void sort(T[] array, ToIntBiFunction<T, T> conditionalOrder);
}
