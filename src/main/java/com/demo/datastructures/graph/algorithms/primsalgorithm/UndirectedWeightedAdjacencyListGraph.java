package com.demo.datastructures.graph.algorithms.primsalgorithm;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.stream.IntStream;

class UndirectedWeightedAdjacencyListGraph {

    @AllArgsConstructor
    static class Edge {
        int vertex;
        int weight;
    }


    private final int vertex;
    private final ArrayList<ArrayList<Edge>> graph;

    public UndirectedWeightedAdjacencyListGraph(int vertex) {
        this.vertex = vertex;
        this.graph = new ArrayList<>();
        IntStream.range(0, vertex)
                .forEach(i -> this.graph.add(new ArrayList<>()));
    }

    public void addEdge(int v1, int v2, int weight) {
        graph.get(v1).add(new Edge(v2, weight));
        graph.get(v2).add(new Edge(v1, weight));
    }


    public ArrayList<ArrayList<Integer>> getMinSpanningTreeUsingPrimsAlgorithm() {
        boolean[] visited = new boolean[vertex];
        int[] weight = new int[vertex];
        int[] parent = new int[vertex];

        // Init weight & parent
        for (int i = 0; i < vertex; i++) {
            if (i == 0) {
                weight[i] = 0;
            } else {
                weight[i] = Integer.MAX_VALUE;
            }
            parent[i] = -1;
        }

        // Evaluate the min weight edges
        for (int i = 0; i < vertex; i++) {
            // Find min weight edge and mark it as visited
            int minWeightEdge = findMinWeightEdge(visited, weight);
            visited[minWeightEdge] = true;

            // For each of the unvisited neighbours update parent and min weight
            for (Edge edge : graph.get(minWeightEdge)) {
                if (!visited[edge.vertex]) {
                    int p = minWeightEdge;
                    int w = edge.weight;
                    int v = edge.vertex;

                    // Find min-weight path
                    if (weight[v] <= w) {
                        w = weight[v];
                        p = parent[v];
                    }

                    // Update weights
                    weight[v] = w;
                    parent[v] = p;
                }
            }
        }

        // Generate min-spanning tree
        ArrayList<ArrayList<Integer>> minSpanningTree = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(i);
            int p = parent[i];
            int w = weight[i];
            // In case parent is -1
            // (for initial node, find node who has 0 as parent and get its vertex and wt)
            if (p == -1) {
                for (int v = 0; v < vertex; v++) {
                    if (parent[v] == i) {
                        p = v;
                        w = weight[v];
                        break;
                    }
                }
            }
            edge.add(p);
            edge.add(w);
            minSpanningTree.add(edge);
        }
        return minSpanningTree;
    }

    private int findMinWeightEdge(boolean[] visited, int[] weight) {
        int minWeight = Integer.MAX_VALUE;
        int minWeightEdge = -1;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && weight[i] < minWeight) {
                minWeight = weight[i];
                minWeightEdge = i;
            }
        }
        return minWeightEdge;
    }

    public void printGraph() {
        System.out.println("Printing weighted undirected edge list graph: ");
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + ": ");
            for (Edge e: graph.get(i)) {
                System.out.print("(v:" + e.vertex + ", w:" + e.weight + "), ");
            }
            System.out.println();
        }
    }

}
