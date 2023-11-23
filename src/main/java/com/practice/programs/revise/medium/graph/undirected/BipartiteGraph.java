package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.Vector;

/**
 * TC: O(v + e), AS: O(v + e)
 */
public class BipartiteGraph {

    private static String possibleBipartition(int n, Vector<Vector<Integer> > edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Vector<Integer> edge: edges) {
            Integer u = edge.get(0);
            Integer v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] assignedPartitions = new int[n + 1];
        return isBipartitie(adjList, 1, n, assignedPartitions, 1) ? "Possible" : "Not Possible";
    }

    private static boolean isBipartitie(
            ArrayList<ArrayList<Integer>> adjList, int currNode, int n, int[] assignedPartitions, int currPartition) {
        assignedPartitions[currNode] = currPartition;
        for (Integer adjNode: adjList.get(currNode)) {
            int nextPartition = 3 - currPartition;
            if (assignedPartitions[adjNode] == 0) {
                if (!isBipartitie(adjList, adjNode, n, assignedPartitions, nextPartition)) {
                    return false;
                }
            } else if (assignedPartitions[adjNode] != nextPartition) {
                return false;
            }
        }
        return true;
    }
}
