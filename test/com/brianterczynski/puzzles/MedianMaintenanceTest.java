package com.brianterczynski.puzzles;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class MedianMaintenanceTest {

    @Test
    public void test() throws Exception {
        MedianMaintenance mm = new MedianMaintenance();
        BufferedReader br = new BufferedReader(
                new InputStreamReader (
                        MedianMaintenanceTest.class.getResourceAsStream("Median.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            mm.addNumber(Long.valueOf(line));
        }
        System.out.println (mm.getMedianSum() % 10000);
    }

    @Test
    public void test2() throws Exception {
        MedianMaintenance mm = new MedianMaintenance();
        int [] items = new int [] {3,5,4};
        for (int i = 0; i < items.length; i++) {
            mm.addNumber(items[i]);
        }
        System.out.println (mm.getMedianSum() % 10000);
    }

    @Test
    public void test3() throws Exception {
        MedianMaintenance mm = new MedianMaintenance();
        int [] items = new int [] {0,0,4,4,4};
        for (int i = 0; i < items.length; i++) {
            mm.addNumber(items[i]);
        }
        System.out.println (mm.getMedianSum() % 10000);
    }

}
