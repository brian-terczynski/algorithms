package com.brianterczynski.algorithms;

public class BinarySearch {
    public static <T extends Comparable> int binarySearch (T [] haystack, T needle) {
        return binarySearch (haystack, needle);
    }
    
    private static <T extends Comparable> int binarySearch (T [] haystack, T needle, int lo, int hi) {
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (needle.compareTo(haystack [mid]) < 0) {
                hi = mid - 1;
            } else if (needle.compareTo(haystack [mid]) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
