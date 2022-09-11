package com.demo.graph.adjacencylist;

public class GraphDemo {

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        undirectedGraph.addVertex(5);
        undirectedGraph.addAdjacentNode(0, 1);
        undirectedGraph.addAdjacentNode(0, 2);
        undirectedGraph.addAdjacentNode(0, 5);
        undirectedGraph.addAdjacentNode(1, 3);
        undirectedGraph.addAdjacentNode(2, 4);
        undirectedGraph.addAdjacentNode(3, 5);
        undirectedGraph.addAdjacentNode(4, 5);

        undirectedGraph.printGraph();
        undirectedGraph.printBreadthFirstTraversal(0);
        undirectedGraph.printBreadthFirstTraversal(3);
    }
}
