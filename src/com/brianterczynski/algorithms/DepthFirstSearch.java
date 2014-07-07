package com.brianterczynski.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch {
    private DirectedGraph graph;
    private int [] finishTimesPerVertex;  // index is the vertex, value is the finish time
    //private int [] vertexPerFinishTimes;  // index is the finish time, value is the vertex
    private int [] leaders;
    private int time;
    private int source;
    private boolean [] visited;

    public DepthFirstSearch (DirectedGraph graph) {
        this.graph = graph;
    }

    public List<List<Integer>> getSCCs () {
        finishTimesPerVertex = new int [graph.numVertices()];
        int [] vertexPerFinishTimes = new int [graph.numVertices()];
        leaders = new int [graph.numVertices()];
        visited = new boolean [graph.numVertices()];
        time = 0;
        source = -1;
        for (int i = graph.numVertices() - 1; i >= 0; i--) {
            if (!visited[i]) {
                source = i;
                dfs2 (i, true);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < finishTimesPerVertex.length; i++) {
            vertexPerFinishTimes[finishTimesPerVertex[i]] = i;
        }
        time = 0;
        source = -1;
        for (int i = vertexPerFinishTimes.length - 1; i >= 0; i--) {
            int u = vertexPerFinishTimes[i];
            if (!visited[u]) {
                source = u;
                dfs2 (u, false);
            }
        }
        Map<Integer, List<Integer>> sccs = new HashMap<Integer, List<Integer>> ();
        for (int i = 0; i < leaders.length; i++) {
            System.out.println(i + " " + leaders[i]);
            if (!sccs.containsKey(leaders[i])) {
                sccs.put(Integer.valueOf(leaders[i]), new LinkedList<Integer>());
            }
            sccs.get(Integer.valueOf(leaders[i])).add(i);
        }
        List<List<Integer>> sccList = new LinkedList<List<Integer>> ();
        for (Map.Entry<Integer,List<Integer>> entry : sccs.entrySet()) {
            sccList.add(entry.getValue());
        }
        return sccList;
    }
    
    public void dfs (int i, boolean getReverse) {
        visited[i] = true;
        leaders[i] = source;
        for (Integer v : graph.adjacent(i, getReverse)) {
            if (!visited[v]) {
                dfs(v, getReverse);
            }
        }
        finishTimesPerVertex[i] = time;
        time++;
    }

    public void dfs2 (int i, boolean getReverse) {
        visited[i] = true;
        leaders[i] = source;
        Stack<Integer> stackNode = new Stack<Integer> ();
        Stack<Iterator<Integer>> stackIterator = new Stack<Iterator<Integer>> ();
        stackNode.push(i);
        stackIterator.push(graph.adjacent(i, getReverse).iterator());
        while (!stackNode.isEmpty()) {
            if (stackIterator.peek().hasNext()) {
                int v = stackIterator.peek().next();
                if (!visited[v]) {
                    stackNode.push(v);
                    stackIterator.push(graph.adjacent(v, getReverse).iterator());
                    visited[v] = true;
                    leaders[v] = source;
                }
            } else {
                int v = stackNode.pop();
                stackIterator.pop();
                finishTimesPerVertex[v] = time;
                time++;
            }
        }
    }
}
