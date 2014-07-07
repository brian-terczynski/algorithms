package com.brianterczynski.algorithms;

public class Insertion <T extends Comparable<T>> {
    public void sort (T [] theArray) {
        int N = theArray.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && theArray[j].compareTo(theArray[j-1]) < 0; j--) {
                T temp = theArray[j];
                theArray[j] = theArray[j-1];
                theArray[j-1] = temp;
            }
        }
    }
}
