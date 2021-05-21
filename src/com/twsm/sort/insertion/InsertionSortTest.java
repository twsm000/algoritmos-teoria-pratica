package com.twsm.sort.insertion;

import com.twsm.sort.Sorter;
import com.twsm.util.ArrayHelper;

public class InsertionSortTest {
    public static void main(String[] args) {
        var array = ArrayHelper.generateIntegers(10, 1, 100);

        System.out.print("Unsorted list: ");
        ArrayHelper.display(array);

        System.out.print("InsertionSort.ascending: ");
        InsertionSort.sort(array, Sorter::ascending);
        ArrayHelper.display(array);

        System.out.print("InsertionSort.descending: ");
        InsertionSort.sort(array, Sorter::descending);
        ArrayHelper.display(array);
    }
}
