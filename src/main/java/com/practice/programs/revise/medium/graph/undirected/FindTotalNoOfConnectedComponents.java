package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/1342638401/
 * TC: O(v + e), AS: O(v + 2e)
 * Concepts:
 * GRAPH
 * CONNECTED_COMPONENTS
 */
public class FindTotalNoOfConnectedComponents {

    int connectedComponentsInGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int connectedComponents = 0;
        boolean[] visited = new boolean[n + 1];
        for (int v = 1; v <= n ; v++) {
            if (!visited[v]) {
                connectedComponents++;
                visit(v, graph, visited);
            }
        }
        return connectedComponents;
    }

    private void visit(int v, List<List<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (int adjNode: graph.get(v)) {
            if (!visited[adjNode]) {
                visit(adjNode, graph, visited);
            }
        }
    }
}
