package com.practice.programs.revise.medium.graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrderInWhichMoviesShouldBeWatched {

    /**
     * Given directed graph, find order in which movies should be watched.
     * If movies can't be watched in any order then return -1
     * TC: O(v + e for build graph + v for indegree + traversal), so O(v + e) where v = no of seasons
     * AS: O(v + e for graph + v for indegree + v for queue), so O(v + e), where v = no of seasons, e = pre
     * Input:
     * 4 4
     * 1 0
     * 2 0
     * 3 1
     * 3 2
     * Output:
     * 0 2 1 3 or 0 1 2 3
     * Concept:
     * GRAPH
     * TOPOLOGICAL_SORT
     * KHANS_ALGORITHM_TOPOLOGICAL_SORT
     */
    static int[] watchMe(int numSeasons, int n, int[][] pre) {
        // Build graph and calcualte indegree
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numSeasons];
        buildGraphNCalculateInDegree(numSeasons, pre, graph, indegree);

        // Find elements with 0 indegree in a queue
        Queue<Integer> q = findElementsWithZeroIndegree(indegree, numSeasons);
        int[] res = new int[numSeasons];
        int resIdx = 0;

        // for each element with 0 indegree in queue
        while (!q.isEmpty()) {
            // add it to result
            int curr = q.poll();
            res[resIdx++] = curr;
            // decrement indegree of all its adjacent nodes
            List<Integer> adjNodes = graph.get(curr);
            for (int node: adjNodes) {
                indegree[node]--;
                // if indegree of any adjacent node is 0, add to queue
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }

        // Do a check if watching all of them is possible (all indegree should be zero)
        boolean isWatchingPossible = resIdx == numSeasons;
        return isWatchingPossible ? res : new int[] {};
    }

    private static Queue<Integer> findElementsWithZeroIndegree(int[] indegree, int numSeasons) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numSeasons; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        return q;
    }

    private static void buildGraphNCalculateInDegree(
            int numSeasons, int[][] pre, List<List<Integer>> graph, int[] indegree) {
        for (int i = 0; i < numSeasons; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair: pre) {
            int v = pair[0];
            int u = pair[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
    }
}
