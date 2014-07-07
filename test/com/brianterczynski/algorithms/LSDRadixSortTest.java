package com.brianterczynski.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class LSDRadixSortTest {

    @Test
    public void test() {
        String [] test = new String [] {"AA","AB","CA","CQ","1A"};
        LSDRadixSort.sort(test, 2);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i] + " ");
        }
    }

}
