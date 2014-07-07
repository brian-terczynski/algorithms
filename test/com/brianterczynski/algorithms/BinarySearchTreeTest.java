package com.brianterczynski.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree<String> bst = new BinarySearchTree<String> ();
        bst.insert("C");
        bst.insert("B");
        bst.insert("A");
        System.out.println (bst);
        System.out.println (bst.reverse());
    }

}
