package com.practice.programs.revise.medium.graph.undirected;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(v + e), where v = no of nodes, e = no of edges
 * AS: O(v + e) for queue, O(v) for visited array
 * <a href="https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class DetectCycleInDirectedGraphBFS {

    boolean detectCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                q.add(new Pair(i, -1));
                if (detectCycleBfs(q, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycleBfs(
            Queue<Pair> q, boolean[] visited, List<List<Integer>> adj) {
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            visited[pair.curr] = true;
            for (Integer adjVertex: adj.get(pair.curr)) {
                if (adjVertex != pair.parent) {
                    if (visited[adjVertex]) {
                        return true;
                    }
                    q.add(new Pair(adjVertex, pair.curr));
                }
            }
        }
        return false;
    }

    static class Pair {
        int curr;
        int parent;
        Pair(int curr, int parent) {
            this.curr = curr;
            this.parent = parent;
        }
    }
}
