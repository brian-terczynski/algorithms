package com.brianterczynski.algorithms;

public class LinkedList<T> {
    private class Node {
        T payload;
        Node next;
    }
    
    private Node head;
    private Node tail;
    private int size = 0;
    
    public void insert (T item) {
        Node newNode = new Node ();
        newNode.payload = item;
        newNode.next = null;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
        size++;
    }

    public void delete (int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node n = head;
        if (i == 0) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
        } else {
            for (int j = 0; j < i - 1; j++) {
                n = n.next;
            }
            if (n.next != null) {
                n.next = n.next.next;
            } else {
                n.next = null;
                tail = n;
            }
            size--;
        }
    }
}
