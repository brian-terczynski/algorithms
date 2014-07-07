package com.brianterczynski.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class SchedulableJob {
    private long weight;
    private long length;
    
    public SchedulableJob (long weight, long length) {
        this.weight = weight;
        this.length = length;
    }

    public long getWeight() {
        return weight;
    }

    public long getLength() {
        return length;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SchedulableJob)) {
            return false;
        }
        SchedulableJob sj = (SchedulableJob) obj;
        return (sj.length == this.length &&
                sj.weight == this.weight);
    }
    
    public static void optimalScheduling (SchedulableJob [] jobs, Comparator<SchedulableJob> comparator) {
        Arrays.sort(jobs, comparator);
    }
    
    public static class DifferenceStrategy implements Comparator <SchedulableJob> {
        @Override
        public int compare(SchedulableJob arg0, SchedulableJob arg1) {
            long arg0Value = arg0.weight - arg0.length;
            long arg1Value = arg1.weight - arg1.length;
            if (arg0Value == arg1Value) {
                if (arg0.weight > arg1.weight) {
                    return -1;
                } else if (arg0.weight < arg1.weight) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (arg0Value > arg1Value) {
                    return -1;
                } else if (arg0Value < arg1Value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static class RatioStrategy implements Comparator <SchedulableJob> {
        @Override
        public int compare(SchedulableJob arg0, SchedulableJob arg1) {
            double arg0Value = (double) arg0.weight / (double) arg0.length;
            double arg1Value = (double) arg1.weight / (double) arg1.length;
            if (arg0Value > arg1Value) {
                return -1;
            } else if (arg0Value < arg1Value) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
