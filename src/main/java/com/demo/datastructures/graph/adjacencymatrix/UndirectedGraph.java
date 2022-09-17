package com.demo.datastructures.graph.adjacencymatrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

    public void breadthFirstTraversal() {
        System.out.println("Depth First Traversal: ");
        HashSet<Integer> hs = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        if (graph.length > 0) {
            q.add(0);
        }
        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (hs.add(vertex)) {
                System.out.print(vertex + " ");
                for (int adjNode = 0; adjNode < graph[vertex].length; adjNode++) {
                    if (graph[vertex][adjNode] == 1 && !hs.contains(adjNode)) {
                        q.add(adjNode);
                    }
                }
            }
        }
        System.out.println();
    }

    public void depthFirstTraversal() {
        System.out.println("Depth First Traversal: ");
        HashSet<Integer> hs = new HashSet<>();

        if (graph.length > 0) {
            depthFirstTraversal(0, hs);
        }
        System.out.println();
    }

    public void depthFirstTraversal(int vertex, HashSet<Integer> hs) {
        if (hs.add(vertex)) {
            System.out.print(vertex + " ");
            for (int adjNode = 0; adjNode < graph[vertex].length; adjNode++) {
                if (graph[vertex][adjNode] == 1 && !hs.contains(adjNode)) {
                    depthFirstTraversal(adjNode, hs);
                }
            }
        }
    }

    public void print() {
        for (int[] r : graph) {
            System.out.println(Arrays.toString(r));
        }
    }
}
