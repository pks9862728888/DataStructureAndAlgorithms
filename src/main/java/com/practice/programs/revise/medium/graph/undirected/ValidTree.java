package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 * All components should be connected + no loop exists
 * TC: O(v + 2E)
 * AS: O(v + 2E) + O(v)
 * Concepts:
 * GRAPH
 * UNDIRECTED_GRAPH
 */
public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        boolean validTree = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (i == 0) {
                    validTree = !loopExistsDfs(graph, 0, -1, visited);
                } else { // All components are not connected
                    validTree = false;
                }
            }
            if (!validTree) {
                break;
            }
        }
        return validTree;
    }

    private boolean loopExistsDfs(
            List<List<Integer>> graph, int idx, int parentIdx, boolean[] visited) {
        visited[idx] = true;
        boolean loopExists = false;
        for (int adjIdx: graph.get(idx)) {
            if (!visited[adjIdx]) {
                loopExists = loopExistsDfs(graph, adjIdx, idx, visited);
            } else if (adjIdx != parentIdx) {
                loopExists = true;
            }
            if (loopExists) {
                break;
            }
        }
        return loopExists;
    }

    private static List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
