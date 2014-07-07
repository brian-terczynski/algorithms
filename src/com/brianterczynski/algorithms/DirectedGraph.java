package com.brianterczynski.algorithms;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
    private Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>> ();
    private Map<Integer,List<Integer>> revAdjList = new HashMap<Integer,List<Integer>> ();
    
    public DirectedGraph () {
    }
    
    public void addEdge(int u, int v) {
        if (!adjList.containsKey(u)) {
            adjList.put(Integer.valueOf(u), new LinkedList<Integer> ());
        }
        if (!adjList.containsKey(v)) {
            adjList.put(Integer.valueOf(v), new LinkedList<Integer> ());
        }
        if (!revAdjList.containsKey(v)) {
            revAdjList.put(Integer.valueOf(v), new LinkedList<Integer> ());
        }
        if (!revAdjList.containsKey(u)) {
            revAdjList.put(Integer.valueOf(u), new LinkedList<Integer> ());
        }
        adjList.get(Integer.valueOf(u)).add(v);
        revAdjList.get(Integer.valueOf(v)).add(u);
    }
    
    public List<Integer> adjacent(int u, boolean getReverse) {
        if (getReverse) {
            return revAdjList.get(u);
        } else {
            return adjList.get(u);
        }
    }
    
    public int numVertices () {
        return adjList.size();
    }
    
    public int numEdges () {
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> item : adjList.entrySet()) {
            i += item.getValue().size();
        }
        return i;
    }
}
