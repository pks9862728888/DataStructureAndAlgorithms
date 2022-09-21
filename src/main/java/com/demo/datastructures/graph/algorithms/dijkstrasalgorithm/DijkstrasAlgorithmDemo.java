package com.demo.datastructures.graph.algorithms.dijkstrasalgorithm;

class DijkstrasAlgorithmDemo {

    public static void main(String[] args) {
        UndirectedWeightedAdjacencyListGraph graph = new UndirectedWeightedAdjacencyListGraph(5);
        graph.addToGraph(0, 1, 4);
        graph.addToGraph(0, 2, 8);
        graph.addToGraph(1, 2, 2);
        graph.addToGraph(1, 3, 6);
        graph.addToGraph(1, 4, 8);
        graph.addToGraph(2, 4, 5);
        graph.addToGraph(2, 3, 3);
        graph.addToGraph(3, 4, 7);
        graph.print();

        graph.findMinDistOfAllNodesFromStartVertexUsingDijkstrasAlgorithm();
    }
}
