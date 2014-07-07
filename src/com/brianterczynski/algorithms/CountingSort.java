package com.brianterczynski.algorithms;

public class CountingSort {
    public static void sort(int [] arrayToSort, int radix) {
        int [] counts = new int [radix+1];
        int [] aux = new int [arrayToSort.length];
        // Count number of items.
        for (int i = 0; i < arrayToSort.length; i++) {
            // Check
            counts[arrayToSort[i]+1]++;
        }
        // Do a cumulative sum.
        for (int i = 0; i < radix; i++) {
            counts[i+1] += counts[i];
        }
        // Copy to aux array
        for (int i = 0; i < arrayToSort.length; i++) {
            aux[counts[arrayToSort[i]]++] = arrayToSort[i];
        }
        // Finally, copy back
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = aux[i];
        }
    }
}
