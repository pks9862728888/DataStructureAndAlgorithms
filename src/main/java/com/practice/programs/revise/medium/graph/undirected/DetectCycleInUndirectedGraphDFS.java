package com.practice.programs.revise.medium.graph.undirected;

import java.util.*;

/**
 * TC: O(v + e), where v = no of nodes, e = no of edges
 * AS: O(v + e) -> v + e -> to store adjacency list, O(v) to store visited array and call stack
 */
public class DetectCycleInUndirectedGraphDFS {

    public static String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {
        // Create graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (ArrayList<Integer> edge: edges) {
            adjList.putIfAbsent(edge.get(0), new ArrayList<>());
            adjList.get(edge.get(0)).add(edge.get(1));
        }
        // Detect cycle
        for (int i = 1; i <= nodes; i++) {
            Set<Integer> visited = new HashSet<>();
            if (!visited.contains(i)) {
                visited.add(i);
                if (isCycleFound(adjList, i, visited, -1)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean isCycleFound(
            Map<Integer, List<Integer>> adjList, Integer currNode, Set<Integer> visited, Integer prev) {
        for (Integer adjNode: adjList.getOrDefault(currNode, new ArrayList<>())) {
            if (prev.equals(adjNode)) {
            } else if (visited.contains(adjNode)) {
                return true;
            } else {
                visited.add(adjNode);
                if (isCycleFound(adjList, adjNode, visited, currNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
