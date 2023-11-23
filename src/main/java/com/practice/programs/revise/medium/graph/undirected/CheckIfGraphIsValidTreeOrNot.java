package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(v + 2e), AS: O(v + 2e) - to create graph, O(v) -> to create visited array
 */
class CheckIfGraphIsValidTreeOrNot {

    // For a graph to be tree
    // It has to be undirected
    // It should not have self loop
    // All vertices have to be connected
    static int graphValidTree(int n, int[][] edges) {
        // Generate graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Validate if graph is a valid tree
        boolean[] visited = new boolean[n];
        if (!isValidTree(graph, 0, visited, -1)) {  // Detect presence of loops
            return 0;
        }
        for (boolean v: visited) { // Detect disconnected components
            if (!v) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean isValidTree(List<List<Integer>> graph, int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer adjNode: graph.get(v)) {
            if (adjNode != parent) {
                if (visited[adjNode] || !isValidTree(graph, adjNode, visited, v)) {
                    return false;
                }
            }
        }
        return true;
    }

}
