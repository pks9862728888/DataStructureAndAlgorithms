package com.practice.programs.revise.medium.graph.undirected;

import java.util.*;

/**
 * Bus routes: [[4, 2, 12], [3, 26], [1, 10], [4, 26, 6]]
 * Src: 3
 * Dest: 12
 * Ans: 3
 * Start with a bus at station 3 and go to station 26.
 * Take the bus from station 26 to station 4, and finally, take another bus from station 4 to station 12.
 * TC: O(R×S) where R is the total number of routes and S is the number of stations
 * AS: O(R×S) where R is the total number of routes and S is the number of stations
 */
public class FindMinBusesRequiredFromSrcToDestination {

    public static int minimumBuses(int[][] busRoutes, int src, int dest) {
        if (src == dest) {
            return 0;
        }
        Map<Integer, List<Integer>> graph = buildGraph(busRoutes);

        // Find routes from source to destination
        Set<Integer> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        visited.add(src);
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int v = pair.v;
            int busesTaken = 1 + pair.busesTaken;
            List<Integer> adjNodes = graph.get(v);
            for (Integer adjNode: adjNodes) {
                if (!visited.contains(adjNode)) {
                    visited.add(adjNode);
                    q.add(new Pair(adjNode, busesTaken));
                    if (adjNode == dest) {
                        return busesTaken;
                    }
                }
            }
        }

        // Find min buses
        return -1;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] busRoutes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] route: busRoutes) {
            for (int i = 1; i < route.length; i++) {
                buildRoute(i, i - 1, graph, route);
            }
            if (route.length > 2) {
                buildRoute(0, route.length - 1, graph, route);
            }
        }
        return graph;
    }

    private static void buildRoute(int uIdx, int vIdx, Map<Integer, List<Integer>> graph, int[] route) {
        int u = route[uIdx];
        int v = route[vIdx];
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static class Pair {
        int v;
        int busesTaken;
        Pair(int v, int busesTaken) {
            this.v = v;
            this.busesTaken = busesTaken;
        }
    }
}
