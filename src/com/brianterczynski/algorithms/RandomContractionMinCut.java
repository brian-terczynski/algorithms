package com.brianterczynski.algorithms;

import java.util.List;
import java.util.Random;

public class RandomContractionMinCut {
    public static int computeMinCut (UndirectedGraph g, int numExperiments) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < numExperiments; i++) {
            UndirectedGraph g2 = new UndirectedGraph(g);
            Random randomU = new Random ();
            Random randomV = new Random ();
            while (g2.numVertices() > 2) {
//                System.out.println(g2.numVertices());
                int u =  g2.getVertexAtIndex(randomU.nextInt(g2.numVertices()));
//                System.out.println("u=" + u);
                List<Integer> adjList = g2.adjacent(u);
                int v = randomV.nextInt(adjList.size());
                g2.contractEdge(u, adjList.get(v));
            }
            int numEdges = g2.adjacent(g2.getVertexAtIndex(0)).size();
            if (numEdges < minCount) {
                minCount = numEdges;
            }
            System.out.println ("Experiment " + i + " Reduced to cut of " + numEdges + " edges, new min=" + minCount);
        }
        return minCount;
    }
}
