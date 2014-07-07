package com.brianterczynski.puzzles;

import java.util.LinkedList;
import java.util.List;

public class TelephoneParser {
    private static final char [][] LETTERSMAP = {
        { '0' },
        { '1' },
            { 'A', 'B', 'C'},
            { 'D', 'E', 'F'},
            { 'G', 'H', 'I'},
            { 'J', 'K', 'L'},
            { 'M', 'N', 'O'},
            { 'P', 'R', 'S'},
            { 'T', 'U', 'V'},
            { 'W', 'X', 'Y'}
    };
    
    public static List<String> numbers (String number) {
        if (number == null) {
            throw new NullPointerException ();
        }
        if (number.length() == 0) {
            throw new IllegalArgumentException ();
        }
        List<String> theList = new LinkedList<String>();
        char [] buildArray = new char [number.length()];
        builder (number, 0, buildArray, theList);
        return theList;
    }
    
    private static void builder (String number, int pos, char [] buildArray, List<String> theList) {
        char [] letters = LETTERSMAP[number.charAt(pos)-'0'];
        for (char letter : letters) {
            // Check trie here
            buildArray[pos] = letter;
            if (pos < number.length() - 1) {
                builder(number, pos+1, buildArray, theList);
            } else {
                theList.add(new String (buildArray, 0, pos+1));
            }
        }
    }
    
    public static void main (String [] args) {
        List<String> strings = numbers("263");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
