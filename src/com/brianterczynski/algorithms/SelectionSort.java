package com.brianterczynski.algorithms;

public class SelectionSort<T extends Comparable<T>> {
    public void sort (T [] items) {
        for (int i = 0; i < items.length; i++) {
            int smallest = i;
            for (int j = i+1; j < items.length; j++) {
                if (items[j].compareTo(items[smallest]) < 0) {
                    smallest = j;
                }
            }
            T temp = items[smallest];
            items[smallest] = items[i];
            items[i] = temp;
        }
    }
}
