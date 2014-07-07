package com.brianterczynski.algorithms;

public class Quicksort3Way {
    private static void exch (Object [] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(Comparable[] a) {
        Shuffler.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort (Comparable [] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            }
            else if (cmp > 0) {
                exch(a, i, gt--);
            }
            else {
                i++;
            }
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}
