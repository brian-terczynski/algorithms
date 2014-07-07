package com.brianterczynski.algorithms;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DepthFirstSearchTest {

    @Test
    public void testSCCs() throws Exception {
        DirectedGraph g = new DirectedGraph ();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 4);
        DepthFirstSearch dfs = new DepthFirstSearch(g);
        List<List<Integer>> sccs = dfs.getSCCs();
        assertEquals(2, sccs.size());

        g = new DirectedGraph ();
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 5);
        dfs = new DepthFirstSearch(g);
        sccs = dfs.getSCCs();
        assertEquals(3, sccs.size());

        g = new DirectedGraph ();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        dfs = new DepthFirstSearch(g);
        sccs = dfs.getSCCs();
        assertEquals(2, sccs.size());

        g = new DirectedGraph ();
        BufferedReader br = new BufferedReader(
                new InputStreamReader (DepthFirstSearch.class.getResourceAsStream("SCC.txt")));
        String line = null;
        int i = 0;
        while ((line = br.readLine()) != null) {
            i++;
            if (i % 10000 == 0) {
                System.out.println("Line " + i);
            }
            String [] split = line.split(" ");
            g.addEdge(Integer.valueOf(split[0])-1, Integer.valueOf(split[1])-1);
        }
        System.out.println(g.numVertices());
        System.out.println(g.numEdges());
        dfs = new DepthFirstSearch(g);
        sccs = dfs.getSCCs();
        System.out.println (sccs.size());
        int [] sizes = new int [sccs.size()];
        i = 0;
        for (List<Integer> scc : sccs) {
            sizes[i] = scc.size();
            i++;
        }
        Arrays.sort(sizes);
        for (int j = sizes.length - 1; j >= sizes.length - 10; j--) {
            System.out.print (sizes[j] + ",");
        }
        System.out.println();
    }
}
