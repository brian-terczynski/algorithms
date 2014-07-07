package com.brianterczynski.algorithms;

import java.util.HashSet;
import java.util.Set;

public class DijkstraShortestPath {
    private UndirectedWeightedGraph g;
    private Set<Integer> processedVertices = new HashSet<Integer> ();
    private double [] shortestPathDistances;
    
    public DijkstraShortestPath (UndirectedWeightedGraph g) {
        this.g = g;
        shortestPathDistances = new double [g.numVertices()];
    }
    
    public double [] getShorestPathsForVertes (int u) {
        processedVertices.add(u);
        while (processedVertices.size() < g.numVertices()) {
            double minPathLength = Double.POSITIVE_INFINITY;
            int uShortest = -1;
            int vShortest = -1;
            double minWeight = Double.POSITIVE_INFINITY;
            for (Integer uStar : processedVertices) {
                for (Edge e : g.adjacent(uStar)) {
                    if (!processedVertices.contains(e.getV()) &&
                            shortestPathDistances[uStar] +
                            e.getWeight() < minPathLength) {
                        uShortest = e.getU();
                        vShortest = e.getV();
                        minWeight = e.getWeight();
                        minPathLength = shortestPathDistances[uStar] +
                                e.getWeight();
                    }
                }
            }
            if (uShortest == -1 && vShortest == -1) {
                break;
            }
            shortestPathDistances[vShortest] = shortestPathDistances[uShortest] +
                    minWeight;
            processedVertices.add(vShortest);
        }
        return shortestPathDistances;
    }
}
