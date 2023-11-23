package com.practice.programs.revise.medium.graph.directed;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(v + e), AS: O(v + e)
 */
class DetectCycle {

    static int cycleDirectedGraph(int n, int[][] edges) {
        // Create directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Detect cycle
        boolean[] visited = new boolean[n + 1];
        boolean[] pathVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && detectCycleDFS(n, i, graph, visited, pathVisited) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static int detectCycleDFS(int n, int v, List<List<Integer>> graph, boolean[] visited,
                                      boolean[] pathVisited) {
        visited[v] = true;
        pathVisited[v] = true;
        for (Integer adjNode: graph.get(v)) {
            if (pathVisited[adjNode] ||
                    v == adjNode ||
                    !visited[adjNode] && detectCycleDFS(n, adjNode, graph, visited, pathVisited) == 1) {
                return 1;
            }
        }
        pathVisited[v] = false;
        return 0;
    }
}
