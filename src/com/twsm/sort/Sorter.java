package com.twsm.sort;

public class Sorter {
    public static <T extends Comparable<? super T>> void ascending(T[] array, SortComparableArray sorter) {
        sorter.sort(array, Sorter::ascending);
    }

    public static <T extends Comparable<? super T>> void descending(T[] array, SortComparableArray sorter) {
        sorter.sort(array, Sorter::descending);
    }

    public static <T extends Comparable<? super T>> int ascending(T v1, T v2) {
        return v1.compareTo(v2);
    }

    public static <T extends Comparable<? super T>> int descending(T v1, T v2) {
        return v2.compareTo(v1);
    }
}
