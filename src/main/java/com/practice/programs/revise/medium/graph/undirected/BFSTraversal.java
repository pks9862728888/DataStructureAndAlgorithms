package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(n + 2e), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/bfs-in-graph_973002?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class BFSTraversal {

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            Integer node = q.poll();
            if (!visited[node]) {
                visited[node] = true;
                bfs.add(node);
                visit(q, adj.get(node), visited);
            }
        }

        return bfs;
    }

    private static void visit(Queue<Integer> q, List<Integer> adjNodes, boolean[] visited) {
        for (Integer adjNode: adjNodes) {
            if (!visited[adjNode]) {
                q.add(adjNode);
            }
        }
    }
}
