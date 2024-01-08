package com.practice.programs.revise.medium.algorithms;

import java.util.*;

/**
 * TC: O(E log n), log n since push and pop operation in PQ takes log n times
 * AS: O(n + E), n = no of nodes in graph, E = no of edges
 */
class FindMinTimeRequiredForSignalToReachFromOneNodeToAnotherDijkstrasAlgorithm {

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Prepare adjacency list
        List<List<DelayPair>> adjList = prepareAdjList(times, n);

        // Find max delay time (Dijkstras algorithm)
        int[] delay = findMaxDelayDijkstrasAlgorithm(n, k, adjList);

        // Return res
        int res = 0;
        for (int i = 1; i < delay.length; i++) {
            int d = delay[i];
            if (d == Integer.MAX_VALUE) { // Not possible to visit node
                return -1;
            } else {
                res = Math.max(res, d);
            }
        }
        return res;
    }

    private static int[] findMaxDelayDijkstrasAlgorithm(int n, int k, List<List<DelayPair>> adjList) {
        int[] delay = new int[n + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        PriorityQueue<DelayPair> pq = new PriorityQueue<>();
        pq.add(new DelayPair(k, 0));
        while (!pq.isEmpty()) {
            DelayPair pair = pq.poll();
            // If delay while visiting via curr node is less than existing then only visit
            if (pair.delay < delay[pair.vertex]) {
                delay[pair.vertex] = pair.delay;
                List<DelayPair> adjNodes = adjList.get(pair.vertex);
                for (DelayPair adjNode: adjNodes) {
                    pq.add(new DelayPair(adjNode.vertex, pair.delay + adjNode.delay));
                }
            }
        }
        return delay;
    }

    private static List<List<DelayPair>> prepareAdjList(int[][] times, int n) {
        List<List<DelayPair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int [] edge: times) {
            int src = edge[0];
            int dest = edge[1];
            int delay = edge[2];
            adjList.get(src).add(new DelayPair(dest, delay));
        }
        for (List<DelayPair> adjNodes: adjList) {
            Collections.sort(adjNodes);
        }
        return adjList;
    }

    private static class DelayPair implements Comparable<DelayPair> {
        int vertex;
        int delay;
        DelayPair(int v, int d) {
            vertex = v;
            delay = d;
        }
        @Override
        public int compareTo(DelayPair o) {
            int res = Integer.compare(delay, o.delay);
            return res == 0 ? Integer.compare(vertex, o.vertex) : res;
        }
        @Override
        public String toString() {
            return String.format("(%s, %s)", vertex, delay);
        }
    }
}
