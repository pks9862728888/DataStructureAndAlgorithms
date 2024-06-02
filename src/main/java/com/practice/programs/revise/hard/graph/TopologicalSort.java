package com.practice.programs.revise.hard.graph;

import java.util.*;

/**
 * https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
 * https://www.geeksforgeeks.org/problems/topological-sort/1
 * TC: O(v + e)
 * AS: O(v)
 */
public class TopologicalSort {

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v + 1];
        Stack<Integer> st = new Stack<>();
        for (int e = 0; e < v; e++) {
            if (!visited[e]) {
                dfs(e, adj, visited, st);
            }
        }
        int[] res = new int[st.size()];
        int idx = 0;
        while (!st.isEmpty()) {
            res[idx++] = st.pop();
        }
        return res;
    }

    private static void dfs(
            int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        for (int e: adj.get(u)) {
            if (!visited[e]) {
                dfs(e, adj, visited, st);
            }
        }
        st.push(u);
    }
}
