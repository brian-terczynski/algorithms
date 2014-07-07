package com.brianterczynski.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountingSortTest {

    @Test
    public void test() {
        int [] test = new int [] {3,2,4,3,5};
        CountingSort.sort(test, 6);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i] + " ");
        }
    }

}
