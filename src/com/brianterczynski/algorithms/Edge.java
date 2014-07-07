package com.brianterczynski.algorithms;

public class Edge {
    private int u;
    private int v;
    private double weight;

    public Edge (int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public double getWeight() {
        return weight;
    }    
}
