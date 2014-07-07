package com.brianterczynski.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class represents an undirected graph.
 * Each vertex is represented as an integer, starting
 * with 0.  This is done for reasons of efficiency, allowing
 * for quick lookups in the internal implementation of
 * the graph.  Typically, to be able to attach general
 * Objects to the vertices, one would use a Map that
 * maps the integer vertices to the Objects (using a
 * Hash Map would make this efficient).
 *
 * @author Brian Terczynski
 */
public class UndirectedWeightedGraph {
    private Map<Integer,List<Edge>> adjList = new HashMap <Integer,List<Edge>> ();
    
    public UndirectedWeightedGraph () {
    }
    
    public boolean hasEdge (int u, int v) {
        List<Edge> adj = adjacent(u);
        for (Edge curEdge : adj) {
            if (v == curEdge.getV()) {
                return true;
            }
        }
        return false;
    }
    
    public void addEdge (int u, int v, double weight, boolean allowParallel) {
//        System.out.println("add edge " + u + " " + v);
        if (!adjList.containsKey(u)) {
            adjList.put(Integer.valueOf(u), new LinkedList<Edge>());
        }
        if (!adjList.containsKey(v)) {
            adjList.put(Integer.valueOf(v),  new LinkedList<Edge>());
        }
        if (allowParallel || !hasEdge(u,v)) {
            adjList.get(u).add(new Edge (u, v, weight));
            adjList.get(v).add(new Edge (v, u, weight));
        }
    }
    
    public int numVertices () {
        return adjList.size();
    }
    
    public int getVertexAtIndex (int index) {
//        System.out.println ("getvertexat=" + index);
        int i = 0;
        Iterator<Map.Entry<Integer,List<Edge>>> iter = adjList.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,List<Edge>> entry = iter.next();
            if (entry.getValue() != null) {
                Integer idx = entry.getKey();
//                System.out.println("..." + idx + adjList.get(idx));
                if (i == index) {
                    return idx;
                }
                i++;
            }
        }
        throw new IndexOutOfBoundsException ();
    }
    
    public List<Edge> adjacent(int u) {
        return adjList.get(u);
    }    
}
