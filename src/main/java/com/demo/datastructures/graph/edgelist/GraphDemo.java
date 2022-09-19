package com.demo.datastructures.graph.edgelist;

import java.util.Arrays;

class GraphDemo {

    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph(8, 13);
        graph.addEdge(0, 3, 1);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(3, 2, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 5, 6);
        graph.addEdge(1, 6, 11);
        graph.addEdge(2, 6, 3);
        graph.addEdge(5, 6, 16);
        graph.addEdge(6, 4, 10);
        graph.addEdge(5, 7, 13);
        graph.addEdge(7, 4, 7);
        graph.addEdge(5, 4, 5);

        // Generate min-spanning tree
        System.out.println("Min Spanning Tree:");
        UndirectedWeightedGraph.Edge[] edges = graph.generateMinSpanningTreeUsingKruskalsAndUnionFindAlgorithm();
        for (UndirectedWeightedGraph.Edge edge: edges) {
            System.out.println(edge);
        }
    }
}
