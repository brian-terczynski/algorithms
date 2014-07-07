package com.brianterczynski.algorithms;

import java.util.Random;

public class Shuffler {
    public static void shuffle (Object [] array) {
        Random r = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            int j = r.nextInt(i - array.length) + i;
            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    public static void shuffle (int [] array) {
        Random r = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            int j = r.nextInt(i - array.length) + i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
