package com.demo.datastructures.graph.adjacencymatrix;

import java.util.Arrays;
import java.util.HashSet;

class UndirectedGraph {

    int v;
    int[][] graph;

    UndirectedGraph(int v) {
        this.v = v;
        this.graph = new int[v][v];
    }

    public void linkVertex(int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    public void depthFirstTraversal() {
        System.out.println("Depth First Traversal: ");
        HashSet<Integer> hs = new HashSet<>();

        if (graph.length > 0) {
            depthFirstTraversal(0, hs);
        }
    }

    public void depthFirstTraversal(int vertex, HashSet<Integer> hs) {
        if (hs.add(vertex)) {
            System.out.print(vertex + " ");
            for (int connectedVertex = 0; connectedVertex < graph[vertex].length; connectedVertex++) {
                if (graph[vertex][connectedVertex] == 1 && !hs.contains(connectedVertex)) {
                    depthFirstTraversal(connectedVertex, hs);
                }
            }
        }
    }

    public void print() {
        for (int[] r: graph) {
            System.out.println(Arrays.toString(r));
        }
    }

}
