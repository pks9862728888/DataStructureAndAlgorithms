package com.practice.programs.revise.medium.graph.dag;

import java.util.*;

/**
 * TC: O(v + e), AS: O(v + e)
 */
public class TopologicalOrdering {

    /**
     * Commonly asked problems related to topological sorting:
     * - Arrange the nodes in a directed, acyclic graph in a special order based on incoming edges
     * - Given a directed graph, find the topological ordering of its vertices
     * - Find the correct scheduling order of tasks which have dependencies
     * - Find the possibility of finishing all courses given the prerequisites for each course
     * - Find the build order for a set of projects with list of dependencies
     * - Find all possible task scheduling orders
     */

    private static Vector<Integer> topologicalOrdering(int n, Vector<Vector<Integer>> edges) {
        int[] indegrees = new int[n + 1];
        List<List<Integer>> graph = initIndegreesAndBuildGraph(edges, indegrees, n);
        Queue<Integer> q = initQueueHavingZeroIndegrees(indegrees);
        Vector<Integer> topologicalOrdering = new Vector<>();
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            topologicalOrdering.add(vertex);
            for (Integer adjNode: graph.get(vertex)) {
                indegrees[adjNode]--;
                if (indegrees[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }
        return topologicalOrdering;
    }

    private static Queue<Integer> initQueueHavingZeroIndegrees(int[] indegrees) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        return q;
    }

    private static List<List<Integer>> initIndegreesAndBuildGraph(
            Vector<Vector<Integer>> edges, int[] indegrees, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (Vector<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            indegrees[v]++;
            graph.get(u).add(v);
        }
        return graph;
    }
}
