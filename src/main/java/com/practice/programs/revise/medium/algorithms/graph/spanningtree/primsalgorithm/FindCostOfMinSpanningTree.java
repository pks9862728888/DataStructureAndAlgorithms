package com.practice.programs.revise.medium.algorithms.graph.spanningtree.primsalgorithm;

import java.util.List;
import java.util.PriorityQueue;

public class FindCostOfMinSpanningTree {

    /**
     * Find min weight of spanning tree
     * TC: E log E, where E = no of edges (in worst case each vertex can be connected to all other nodes)
     * AS: log E
     * Concepts:
     * GRAPH
     * SPANNING_TREE
     * PRIMS_ALGORITHM
     * <a href="https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1">Practice Link</a>
     */
    static int spanningTreePrimsAlgorithm(int v, int E, List<List<int[]>> adj) {
        // Create a min heap PQ on wt (wt, source, parent)
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        // Create visited array to mark which nodes are already visited
        boolean[] visited = new boolean[v + 1];

        // Crate a variable to track sumWeights
        int sumWeights = 0;

        // Start from any node
        // Insert 0, 0, -1 in PQ initially
        pq.add(new Tuple(0, -1, 0));
        while (!pq.isEmpty()) {
            // Pop node from PQ
            Tuple curr = pq.poll();
            // if node is not already visited
            if (!visited[curr.node]) {
                // Mark node as visited
                visited[curr.node] = true;
                // update sumWeights
                sumWeights += curr.weight;
                // put all its adjacent nodes in PQ
                List<int[]> adjNodes = adj.get(curr.node);
                for (int[] pair: adjNodes) {
                    int adjV = pair[0];
                    int wt = pair[1];
                    if (!visited[adjV]) {
                        pq.add(new Tuple(adjV, curr.node, wt));
                    }
                }
            }
        }

        // Return result
        return sumWeights;
    }

    private static class Tuple {
        int node;
        int parent;
        int weight;
        public Tuple(int n, int p, int w) {
            node = n;
            parent = p;
            weight = w;
        }
    }
}
