package com.practice.programs.revise.medium.graph.undirected;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PathsInMaze {

    /**
     * There are n rooms 1 .. n
     * Each of them are connected by corridor
     * Return the confusion score, i.e. total count of corridor which connects two rooms together
     * TC: O(E * (v + log v)), where v = no of rooms = n
     * AS: O (E)
     */

    public static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        int noOfPaths = 0;
        for (int[] corridor: corridors) {
            adjList.putIfAbsent(corridor[0], new TreeSet<>());
            adjList.putIfAbsent(corridor[1], new TreeSet<>());
            adjList.get(corridor[0]).add(corridor[1]);
            adjList.get(corridor[1]).add(corridor[0]);

            noOfPaths += countCommonPaths(adjList.get(corridor[0]), adjList.get(corridor[1]));
        }
        return noOfPaths;
    }

    private static int countCommonPaths(Set<Integer> adjNodeList1, Set<Integer> adjNodeList2) {
        int commonAdjNodeCount = 0;
        for (Integer node: adjNodeList1) {
            if (adjNodeList2.contains(node)) {
                commonAdjNodeCount++;
            } else {
                break;
            }
        }
        return commonAdjNodeCount;
    }
}
