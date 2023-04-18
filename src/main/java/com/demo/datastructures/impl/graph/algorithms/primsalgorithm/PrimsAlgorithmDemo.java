package com.demo.datastructures.impl.graph.algorithms.primsalgorithm;

import java.util.ArrayList;

class PrimsAlgorithmDemo {

    public static void main(String[] args) {
        UndirectedWeightedAdjacencyListGraph graph = new UndirectedWeightedAdjacencyListGraph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 4, 5);
        graph.printGraph();

        System.out.println("Min Spanning Tree using Prims algorithm: ");
        ArrayList<ArrayList<Integer>> minSpanningTree =
                graph.getMinSpanningTreeUsingPrimsAlgorithm();
        for (ArrayList<Integer> edge : minSpanningTree) {
            System.out.println(edge);
        }
    }
}
