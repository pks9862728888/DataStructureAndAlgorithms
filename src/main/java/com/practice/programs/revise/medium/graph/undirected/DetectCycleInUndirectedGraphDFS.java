package com.practice.programs.revise.medium.graph.undirected;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * TC: O(v + e), where v = no of nodes, e = no of edges
 * AS: O(v + e) -> v + e -> to store adjacency list, O(v) to store visited array and call stack
 * Concepts:
 * GRAPH
 * DFS_GRAPH
 * UNDIRECTED_GRAPH
 */
public class DetectCycleInUndirectedGraphDFS {

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean isCycle = false;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                isCycle = dfs(adj, i, -1, visited);
                if (isCycle) {
                    break;
                }
            }
        }
        return isCycle;
    }

    private boolean dfs(
            ArrayList<ArrayList<Integer>> adj, int idx, int pIdx, boolean[] visited) {
        visited[idx] = true;
        boolean loopExists = false;
        for (Integer adjIdx: adj.get(idx)) {
            if (!visited[adjIdx]) {
                loopExists = dfs(adj, adjIdx, idx, visited);
            } else if (pIdx != adjIdx) { // Since undirected, so we will also have link to parent, so ignore that
                loopExists = true;
            }
            if (loopExists) {
                break;
            }
        }
        return loopExists;
    }
}
