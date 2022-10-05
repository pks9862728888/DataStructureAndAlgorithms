package com.demo.datastructures.graph.algorithms.topologicalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Applicable for directed acyclic graph only
 * TOPO sort:
 * Linear ordering of vertices such that if there is an edge u -> v, then u appears before v
 * <p>
 * PS: There can be multiple topo sort for a graph
 */
class TopologicalSortDemo {

    public static void main(String[] args) {
        // Create directed acyclic graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int noOfVertex = 6;
        graph.add(new ArrayList<>());  // 0
        graph.add(new ArrayList<>());  // 1
        graph.add(new ArrayList<>(List.of(3)));  // 2
        graph.add(new ArrayList<>(List.of(1)));  // 3
        graph.add(new ArrayList<>(List.of(0, 1)));  // 4
        graph.add(new ArrayList<>(List.of(0, 2)));  // 5

        // Topological sort using DFS
        System.out.println(topoSortUsingDFS(noOfVertex, graph));
    }

    /**
     * TC : O (V + E)
     * AS : O (V) -> O(v) visited array, O(v) for topo sort result
     */
    private static ArrayList<Integer> topoSortUsingDFS(int v, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> topoSort = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, topoSort);
            }
        }

        return topoSort;
    }

    private static void dfs(int curr, boolean[] visited,
                            ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> topoSort) {
        // Mark current node as visited
        visited[curr] = true;

        // Traverse adj nodes
        for (int adjNode : graph.get(curr)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, graph, topoSort);
            }
        }

        // Add current node
        topoSort.add(0, curr);
    }

}
