package com.twsm.sort.selection;

import com.twsm.sort.Sorter;
import com.twsm.util.ArrayHelper;

public class SelectionSortTest {
    public static void main(String[] args) {
        var array = ArrayHelper.generateIntegers(10, 1, 100);

        System.out.print("Unsorted list: ");
        ArrayHelper.display(array);

        System.out.print("SelectionSort: ");
        SelectionSort.sort(array, Sorter::ascending);
        ArrayHelper.display(array);

        System.out.print("SelectionSort.descending: ");
        SelectionSort.sort(array, Sorter::descending);
        ArrayHelper.display(array);
    }
}
