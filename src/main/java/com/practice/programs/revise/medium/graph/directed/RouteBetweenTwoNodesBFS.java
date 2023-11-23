package com.practice.programs.revise.medium.graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(v + e), AS: O(v + e)
 */
class RouteBetweenTwoNodesBFS {

    boolean routeBetweenNodes(
            int source, int destination, int n,  ArrayList<ArrayList<Integer>> edges) {
        // Generate directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge: edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }
        // Find if route exists
        boolean[] visited = new boolean[n + 1];
        return isRouteExists(graph, source, destination, visited);
    }

    private boolean isRouteExists(List<List<Integer>> graph, int source, int destination,
                                  boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            int currNode = q.poll();
            visited[currNode] = true;
            for (Integer adjNode: graph.get(currNode)) {
                if (adjNode == destination) {
                    return true;
                } else if (!visited[adjNode]) {
                    q.add(adjNode);
                }
            }
        }
        return false;
    }
}
