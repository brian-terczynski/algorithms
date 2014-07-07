package com.brianterczynski.algorithms;

public class PriorityQueue<T extends Comparable> {
    T [] pq;
    int size = 0;
    
    public PriorityQueue () {
        pq = (T []) new Object [100];
    }

    public void insert (T item) {
        pq[++size] = item;
    }
    
    private void swim(int k) {
        while (k > 1 && pq[k/2].compareTo(pq[k]) < 0) {
            T temp = pq[k];
            pq[k] = pq[k/2];
            pq[k/2] = temp;
        }
    }
    
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && pq[j].compareTo(pq[j+1]) < 0) {
                j++;
            }
            if (pq[k].compareTo(pq[j]) >= 0) {
                break;
            }
            T temp = pq[k];
            pq[k] = pq[j];
            pq[j] = temp;
            k = j;
        }
    }
}
