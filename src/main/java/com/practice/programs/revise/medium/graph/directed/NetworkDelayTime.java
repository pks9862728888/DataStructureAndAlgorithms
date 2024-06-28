package com.practice.programs.revise.medium.graph.directed;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    /**
     * Find time required for signal from node k to reach all other nodes
     * TC: (V + E) for build graph + E log V for while loop (since we are not storing duplicate edges so not E log E)
     * AS: O(V + E)
     * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
     * Output: 2
     * <a href="https://leetcode.com/problems/network-delay-time/description/">Practice Link</a>
     * Concept:
     * GRAPH
     * DIJKSTRAS_ALGORITHM
     */
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<List<Pair>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n + 1];
        int maxDelay = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.getWt() - b.getWt());
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int v = curr.getV();
            if (!visited[v]) {
                visited[v] = true;
                maxDelay = Math.max(maxDelay, curr.getWt());
                List<Pair> adjVertices = graph.get(v);
                for (Pair adjV: adjVertices) {
                    if (!visited[adjV.getV()]) {
                        int wt = curr.getWt() + adjV.getWt();
                        pq.add(new Pair(adjV.getV(), wt));
                    }
                }
            }
        }

        // return res
        return isSomeNodesUnvisited(visited) ? -1 : maxDelay;
    }

    private static boolean isSomeNodesUnvisited(boolean[] visited) {
        int n = visited.length;
        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }

    private static List<List<Pair>> buildGraph(int n, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v, w));
        }
        return graph;
    }

    private static class Pair {
        private int v;
        private int wt;
        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        public int getV() {
            return this.v;
        }
        public int getWt() {
            return this.wt;
        }
    }
}
