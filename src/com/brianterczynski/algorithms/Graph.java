package com.brianterczynski.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public class Edge {
        int v;
        int w;
        double weight;
        
        public Edge (int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        
        public int getV() {
            return v;
        }
        
        public int getW() {
            return w;
        }
        
        public double getWeight() {
            return weight;
        }
    }
    
    private Map<Integer, List<Edge>> adjList;
    private boolean isUnidirectional = false;
    
    public Graph (boolean isUnidirectional) {
        adjList = new HashMap<Integer, List<Edge>> ();
        this.isUnidirectional = isUnidirectional;
    }
    
    public List<Edge> adj (int v) {
        return adjList.get(v);
    }
    
    public void addEdge(int v, int w, int weight) {
        if (!adjList.containsKey(v)) {
            adjList.put(v, new ArrayList<Edge> ());
        }
        adjList.get(v).add(new Edge (v, w, weight));
        if (!isUnidirectional) {
            return;
        }
        if (!adjList.containsKey(w)) {
            adjList.put(w, new ArrayList<Edge> ());
        }
        adjList.get(w).add(new Edge (w, v, weight));
    }

    public class BFS {
        private List<Integer> vertices;
        boolean marked [];
        int edgeTo [];
        boolean usePostOrder = false;
        
        public BFS (int v, boolean usePostOrder) {
            marked = new boolean [Graph.this.adjList.size()];
            this.usePostOrder = usePostOrder;
            vertices = new ArrayList<Integer>();
            bfs (v);            
        }
        
        private void bfs (int v) {
            marked[v] = true;
            Deque<Integer> q = new ArrayDeque<Integer> ();
            q.add(v);
            while (!q.isEmpty()) {
                Integer s = q.remove();
                for (Edge e : adj(s)) {
                    if (!marked[e.getW()]) {
                        marked[e.getW()] = true;
                        edgeTo[e.getW()] = v;
                        q.add(e.getW());
                    }
                }
            }
        }
    }

    public class DFOrder {
        private List<Integer> preorder;
        private List<Integer> postorder;
        
        boolean marked [];
        boolean usePostOrder = false;
        
        public DFOrder () {
            marked = new boolean [Graph.this.adjList.size()];
            preorder = new ArrayList<Integer>();
            postorder = new ArrayList<Integer>();
            for (Integer v : adjList.keySet()) {
                if (!marked[v]) {
                    dfs (v);
                }
            }
        }
        
        private void dfs (int v) {
            marked[v] = true;
            preorder.add(v);
            for (Edge edge : adj(v)) {
                if (!marked[edge.getW()]) {
                    dfs(edge.getW());
                } // TODO Check for cycle here
            }
            postorder.add(v);
        }

        public Integer[] preorder() {
            return preorder.toArray(new Integer[0]);
        }
        public Integer[] postorder() {
            return postorder.toArray(new Integer[0]);            
        }
        public Integer[] reversePostorder() {
            Integer [] revPostorder = new Integer [postorder.size()];
            for (int i = 0, j = postorder.size()-1; i < postorder.size(); i++, j--) {
                revPostorder[i] = postorder.get(j);
            }
            return revPostorder;
        }
    }

    public class DFS {
        boolean marked [];
        int edgeTo [];
        
        public DFS (int v, boolean usePostOrder) {
            marked = new boolean [Graph.this.adjList.size()];
            dfs (v);
        }
        
        private void dfs (int v) {
            marked[v] = true;
            for (Edge edge : adj(v)) {
                if (!marked[edge.getW()]) {
                    edgeTo[edge.getW()] = v;
                    dfs(edge.getW());
                } // TODO Check for cycle here
            }
        }
    }
}
