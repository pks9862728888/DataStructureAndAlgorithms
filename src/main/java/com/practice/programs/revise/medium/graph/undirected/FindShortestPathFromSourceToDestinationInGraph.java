package com.practice.programs.revise.medium.graph.undirected;

import java.util.*;

/**
 * TC: O(V + E). Here V and E denote the number of vertices and edges in the graph respectively
 * AS: O(V + 2E) - To store the adjacency list.
 *  To store the visited array and the recursion stack, O(V) space is needed.
 * BFS will always give us shortest path
 */
public class FindShortestPathFromSourceToDestinationInGraph {

    public static List<Integer> shortestPath(
            int n, List<List<Integer>> edges, int source, int destination) {
        List<List<Integer>> graph = buildGraph(edges, n);
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        List<Integer> shortestPath = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            if (curr == destination) {
                return buildPath(source, destination, parent);
            } else {
                for (Integer adjNode: graph.get(curr)) {
                    if (!visited[adjNode]) {
                        visited[adjNode] = true;
                        parent[adjNode] = curr;
                        q.add(adjNode);
                    }
                }
            }
        }
        return shortestPath;
    }

    private static List<Integer> buildPath(int source, int destination, int[] parent) {
        List<Integer> path = new ArrayList<>();
        int i = destination;
        while (i != source) {
            path.add(i);
            i = parent[i];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    private static List<List<Integer>> buildGraph(List<List<Integer>> edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
