package com.brianterczynski.algorithms;

public class LSDRadixSort {
    public static void sort(String[] arrayToSort, int stringWidth) {
        int radix = 256;  // Need it for each possible character.
        int arraySize = arrayToSort.length;
        String [] aux = new String [arraySize];
        for (int d = stringWidth-1; d >= 0; d--) {
            int [] count = new int[radix + 1];
            for (int i = 0; i < arraySize; i++) {
                count[arrayToSort[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < radix; r++) {
                count[r+1] += count[r];
            }
            for (int i = 0; i < arraySize; i++) {
                aux[count[arrayToSort[i].charAt(d)]++] = arrayToSort[i];
            }
            for (int i = 0; i < arrayToSort.length; i++) {
                arrayToSort[i] = aux[i];
            }
        }
    }
}
