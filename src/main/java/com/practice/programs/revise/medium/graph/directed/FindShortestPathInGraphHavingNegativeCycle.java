package com.practice.programs.revise.medium.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;

public class FindShortestPathInGraphHavingNegativeCycle {

    private static final int MAX_DIST = (int) 1e8;

    /**
     * Find shortest path in directed graph having -ve cycle.
     * If -ve cycle exists, return an array having -1
     * TC: O(n * E) where n = no of vertex, E = no of edges
     * AS: O(n) for distance array
     * <a href="https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1">PracticeLink</a>
     * Input:
     * edges: [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
     * s = 2
     * Output: 1 6 0
     * Concept:
     * GRAPH
     * BELLMAN_FORDS_ALGORITHM
     */
    static int[] bellmanFord(int n, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[s] = 0;
        // Iterate through the edges n - 1 times
        for (int i = 0; i < n; i++) {
            for (ArrayList<Integer> edge: edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dist[u] != MAX_DIST && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Detect if graph contains -ve cycle
        if (isGraphContainsNegativeCycle(edges, dist)) {
            dist = new int[] {-1};
        }
        return dist;
    }

    private static boolean isGraphContainsNegativeCycle(ArrayList<ArrayList<Integer>> edges, int[] dist) {
        boolean isNegCycle = false;
        for (ArrayList<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (dist[u] != MAX_DIST && dist[u] + wt < dist[v]) { // -ve cycle
                isNegCycle = true;
                break;
            }
        }
        return isNegCycle;
    }
}
