package com.brianterczynski.algorithms;

public class Quicksort {
    private static int partition (Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while (true) {
            while (a[++i].compareTo(a[lo]) < 0) {
                if (i == hi) break;
            }
            while (a[lo].compareTo(a[--j]) < 0) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch (Object [] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(Comparable[] a) {
        Shuffler.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static Object kThLargest(Comparable[] a, int k) {
        Shuffler.shuffle(a);
        return kThLargest(a, 0, a.length-1, k);
    }

    private static Object kThLargest (Comparable [] a, int lo, int hi, int k) {
        if (hi <= lo) return null;
        int j = partition (a, lo, hi);
        if (j == k) {
            return a[j];
        } else if (j < k) {
            return kThLargest (a, j+1, hi, k);
        } else {
            return kThLargest (a, lo, j-1, k);
        }
    }

    private static void sort (Comparable [] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition (a, lo, hi);
        sort (a, lo, j-1);
        sort (a, j+1, hi);
    }
}
