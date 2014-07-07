package com.brianterczynski.puzzles;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TwoSum {
    public static int getNumberOfTwoSums (long [] array, long startTargetValue, long endTargetValue) {
        Set<Long> hashTable = new HashSet<Long>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            hashTable.add(array[i]);
        }
        for (long targetValue = startTargetValue; targetValue <= endTargetValue; targetValue++) {
            if (targetValue % 100 == 0) {
                System.out.println("TargetValue:" + targetValue);
            }
            for (int j = 0; j < array.length; j++) {
                long x = array[j];
                long y = targetValue - x;
                if (x != y && hashTable.contains(y)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    public static int getNumberOfTwoSums2 (long [] array, long startTargetValue, long endTargetValue) {
        TreeSet<Long> hashTable = new TreeSet<Long>();
        Set<Long> targetHits = new HashSet<Long> ();
        for (int i = 0; i < array.length; i++) {
            hashTable.add(array[i]);
        }
        for (int j = 0; j < array.length; j++) {
            long x = array[j];
            long lowTarget = startTargetValue - x;
            long highTarget = endTargetValue - x;
            Set<Long> ySet = hashTable.subSet(lowTarget, highTarget);
            for (Long y : ySet) {
                if (y != x) {
                    targetHits.add(x + y);
                }
            }
        }
        return targetHits.size();
    }

}
