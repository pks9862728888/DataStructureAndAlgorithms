package com.practice.programs.revise.hard.graph;

import java.util.*;

/**
 * https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
 * https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 * https://www.geeksforgeeks.org/problems/topological-sort/1
 * TC: O(v + e)
 * AS: O(v)
 */
public class TopologicalSort {

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        // return topoSortDfs(v, adj);
        return topoSortKhansAlgoBfs(v, adj);
    }

    private static int[] topoSortKhansAlgoBfs(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = initIndegree(v, adj);
        Queue<Integer> q = new LinkedList<>();
        insertEleWithZeroIndegree(q, indegree);
        int[] res = new int[v];
        int idx = 0;
        while (!q.isEmpty()) {
            int currV = q.poll();
            for (int adjV: adj.get(currV)) {
                if (indegree[adjV] != 0) {
                    indegree[adjV]--;
                    if (indegree[adjV] == 0) {
                        q.offer(adjV);
                    }
                }
            }
            res[idx++] = currV;
        }
        return res;
    }

    private static void insertEleWithZeroIndegree(Queue<Integer> q, int[] indegree) {
        for (int v = 0; v < indegree.length; v++) {
            if (indegree[v] == 0) {
                q.offer(v);
            }
        }
    }

    private static int[] initIndegree(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjEle: adj.get(i)) {
                indegree[adjEle]++;
            }
        }
        return indegree;
    }

    private static int[] topoSortDfs(int v, ArrayList<ArrayList<Integer>> adj) {
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
