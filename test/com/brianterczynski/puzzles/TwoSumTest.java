package com.brianterczynski.puzzles;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void test1() {
        long [] array = {1,3,3,4};
        assertEquals (2, TwoSum.getNumberOfTwoSums2(array, 3, 6));
    }

    @Test
    public void test2() {
        long [] array = {1,2,3,3};
        assertEquals (3, TwoSum.getNumberOfTwoSums2(array, 3, 6));
    }

    @Test
    public void testFile() throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        TwoSumTest.class.getResourceAsStream("2sum.txt")));
        String line;
        List<Long> input = new ArrayList<Long> ();
        while ((line = br.readLine()) != null) {
            input.add(Long.valueOf(line));
        }
        long [] array = new long [input.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.get(i);
        }
        long [] targetValues = new long [20001];
        for (int i = -10000; i <= 10000; i++) {
            targetValues[i+10000] = i;
        }
        System.out.println (TwoSum.getNumberOfTwoSums(array, -10000, 10000));
    }

}
