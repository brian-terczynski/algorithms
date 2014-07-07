package com.brianterczynski.puzzles;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianMaintenance {
    private PriorityQueue<Long> pqLow = new PriorityQueue<Long> (11, new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
            return o2.compareTo(o1);
        }
    });
    private PriorityQueue<Long> pqHigh = new PriorityQueue<Long> ();
    
    long medianSum = 0;
    
    public void addNumber (long number) {
        if (pqLow.size() == 0 && pqHigh.size() == 0) {
            pqLow.add(number);
        } else if (pqLow.size() + pqHigh.size() == 1) {
            if (pqLow.peek() > number) {
                pqHigh.add(pqLow.remove());
                pqLow.add(number);
            } else {
                pqHigh.add(number);
            }
        } else if (number < pqLow.peek()) {
            pqLow.add(number);
        } else {
            pqHigh.add(number);
        }
        if (pqLow.size() > pqHigh.size() + 1) {
            pqHigh.add(pqLow.remove());
        }
        if (pqHigh.size() > pqLow.size() + 1) {
            pqLow.add(pqHigh.remove());
        }
        assert(pqLow.size() == pqHigh.size() ||
                pqLow.size() - pqHigh.size() == 1 ||
                pqHigh.size() - pqLow.size() == 1);
        long median;
        if (pqLow.size() == pqHigh.size()) {
            median = pqLow.peek();
        } else if (pqLow.size() > pqHigh.size()) {
            median = pqLow.peek();
        } else {
            median = pqHigh.peek();
        }
        medianSum += median;
    }

    public long getMedianSum () {
        return medianSum;
    }
}
