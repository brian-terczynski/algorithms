package com.brianterczynski.algorithms;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class DijkstraShortestPathTest {

    @Test
    public void test() {
        UndirectedWeightedGraph g = new UndirectedWeightedGraph ();
        g.addEdge(0, 1, 3.0, true);
        g.addEdge(1, 2, 1.0, true);
        g.addEdge(0, 2, 2.0, true);
        DijkstraShortestPath dsp = new DijkstraShortestPath (g);
        double [] d = dsp.getShorestPathsForVertes(0);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();
    }

    @Test
    public void test2() {
        UndirectedWeightedGraph g = new UndirectedWeightedGraph ();
        g.addEdge(0, 1, 1.0, true);
        g.addEdge(0, 2, 3.0, true);
        g.addEdge(2, 3, 4.0, true);
        g.addEdge(1, 3, 15.0, true);
        g.addEdge(1, 4, 900.0, true);
        g.addEdge(3, 4, 2.0, true);
        g.addEdge(5, 6, 3.0, true);
        DijkstraShortestPath dsp = new DijkstraShortestPath (g);
        double [] d = dsp.getShorestPathsForVertes(0);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();
    }

    @Test
    public void testNegative() {
        UndirectedWeightedGraph g = new UndirectedWeightedGraph ();
        g.addEdge(0, 1, 1.0, true);
        g.addEdge(0, 2, -2.0, true);
        g.addEdge(0, 3, -3.0, true);
        g.addEdge(1, 2, 1.0, true);
        g.addEdge(2, 3, 1.0, true);
        DijkstraShortestPath dsp = new DijkstraShortestPath (g);
        double [] d = dsp.getShorestPathsForVertes(0);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();
    }

    @Test
    public void testHW() throws Exception {
        UndirectedWeightedGraph g = new UndirectedWeightedGraph ();
        BufferedReader br = new BufferedReader (new InputStreamReader
                (DijkstraShortestPathTest.class.getResourceAsStream("dijkstraData.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            String [] split = line.split("\t");
            int u = Integer.valueOf(split[0]) - 1;
            for (int j = 1; j < split.length; j++) {
                String [] split2 = split[j].split(",");
                g.addEdge(u, Integer.valueOf(split2[0]) - 1,
                        Double.valueOf(split2[1]), true);
            }
        }
        DijkstraShortestPath dsp = new DijkstraShortestPath (g);
        double [] d = dsp.getShorestPathsForVertes(0);
        for (int i = 0; i < d.length; i++) {
            System.out.print((int)d[i] + ",");
        }
        System.out.println();
        System.out.println((int)d[6] + "," + (int)d[36] + "," + (int)d[58] + "," +
                (int)d[81] + "," + (int)d[98] + "," + (int)d[114] + "," + (int)d[132] + "," +
                (int)d[164] + "," + (int)d[187] + "," + (int)d[196]);
        //7,37,59,82,99,115,133,165,188,197
        System.out.println();
    }
}
