package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(v + 2e), AS: O(v + 2e)
 * <a href="https://www.codingninjas.com/studio/problems/dfs-traversal_630462?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class DFSTraversal {

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(
            int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Create graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge: edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        // Traverse and print dfs paths
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> currPath = new ArrayList<>();
                res.add(currPath);
                visit(adjList, i, currPath, visited);
            }
        }
        return res;
    }

    private static void visit(
            List<List<Integer>> adjList, int i, ArrayList<Integer> currPath, boolean[] visited) {
        visited[i] = true;
        currPath.add(i);
        for (Integer adjNode: adjList.get(i)) {
            if (!visited[adjNode]) {
                visit(adjList, adjNode, currPath, visited);
            }
        }
    }
}
