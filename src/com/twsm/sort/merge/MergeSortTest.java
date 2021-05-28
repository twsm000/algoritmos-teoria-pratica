package com.twsm.sort.merge;

import com.twsm.sort.Sorter;
import com.twsm.util.ArrayHelper;

public class MergeSortTest {
    public static void main(String[] args) {
        var array = ArrayHelper.generateIntegers(10, 1, 100);

        System.out.print("Unsorted list: ");
        ArrayHelper.display(array);

        System.out.print("MergeSort.ascending: ");
        MergeSort.sort(array, Sorter::ascending);
        ArrayHelper.display(array);

        System.out.print("MergeSort.descending: ");
        MergeSort.sort(array, Sorter::descending);
        ArrayHelper.display(array);
    }
}
