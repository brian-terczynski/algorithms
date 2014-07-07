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
public class UndirectedGraph {
    private Map<Integer,List<Integer>> adjList = new HashMap <Integer,List<Integer>> ();
    
    public UndirectedGraph () {
    }
    
    public UndirectedGraph (UndirectedGraph g) {
        for (Map.Entry<Integer, List<Integer>> entry : g.adjList.entrySet()) {
            adjList.put(entry.getKey(), new LinkedList<Integer>());
            for (Integer i : entry.getValue()) {
                adjList.get(entry.getKey()).add(i);
            }
        }
    }
    
    public boolean hasEdge (int u, int v) {
        List<Integer> adj = adjacent(u);
        for (Integer curV : adj) {
            if (v == curV) {
                return true;
            }
        }
        return false;
    }
    
    public void addEdge (int u, int v, boolean allowParallel) {
//        System.out.println("add edge " + u + " " + v);
        if (!adjList.containsKey(u)) {
            adjList.put(Integer.valueOf(u), new LinkedList<Integer>());
        }
        if (!adjList.containsKey(v)) {
            adjList.put(Integer.valueOf(v),  new LinkedList<Integer>());
        }
        if (allowParallel || !hasEdge(u,v)) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
    
    public int numVertices () {
        return adjList.size();
    }
    
    public int getVertexAtIndex (int index) {
//        System.out.println ("getvertexat=" + index);
        int i = 0;
        Iterator<Map.Entry<Integer,List<Integer>>> iter = adjList.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,List<Integer>> entry = iter.next();
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
    
    public void removeEdge (int u, int v, boolean removeOrphans) {
//        System.out.println("remove edge " + u + " " + v);
        if (adjList.get(u) != null) {
            Iterator<Integer> iter = adjList.get(u).iterator();
            while (iter.hasNext()) {
                Integer i = iter.next();
                if (i == v) {
                    iter.remove();
                }
            }
        }
        if (adjList.get(v) != null) {
            Iterator<Integer> iter = adjList.get(v).iterator();
            while (iter.hasNext()) {
                Integer i = iter.next();
                if (i == u) {
                    iter.remove();
                }
            }
        }
        if (removeOrphans) {
            if (adjList.get(u) != null && adjList.get(u).size() == 0) {
                adjList.remove(u);
//                System.out.println("Removed u=" + u);
            }
            if (adjList.get(v) != null && adjList.get(v).size() == 0) {
                adjList.remove(v);
//                System.out.println("Removed v=" + v);
            }
        }
    }
    
    public List<Integer> adjacent(int u) {
        return adjList.get(u);
    }
    
    /**
     * This contracts the vertex v into u.  It removes
     * all edges between u and v.  It then repoints any
     * edges that were pointing to v to point to u.
     * 
     * @param u
     *   The source vertex of the edge.
     * @param v
     *   The sink vertext of the edge.
     */
    public void contractEdge (int u, int v) {
        removeEdge(u, v, true);
        if (adjList.get(v) != null && adjList.get(v).size() > 0) {
            Integer [] adjToV = adjList.get(v).toArray(new Integer [adjList.get(v).size()]);
            for (int i = 0; i < adjToV.length; i++) {
                removeEdge(v, adjToV[i], true);
                addEdge(u, adjToV[i], true);
            }
        }
    }
}
