package com.demo.datastructures.graph.adjacencylist;

public class GraphDemo {

    public static void main(String[] args) {
        // Connected graph
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
        undirectedGraph.printBreadthFirstTraversalConnectedGraph(0);
        undirectedGraph.printBreadthFirstTraversalConnectedGraph(3);

        // Disconnected graph (e.g. Web crawlers crawling web pages)
        UndirectedGraph disconnectedGraph = new UndirectedGraph();
        disconnectedGraph.addVertex(6);
        // Connected section - 1
        disconnectedGraph.addAdjacentNode(0, 1);
        disconnectedGraph.addAdjacentNode(0, 2);
        disconnectedGraph.addAdjacentNode(1, 3);
        disconnectedGraph.addAdjacentNode(2, 3);
        // Connected section - 2
        disconnectedGraph.addAdjacentNode(4, 5);
        disconnectedGraph.addAdjacentNode(4, 6);
        disconnectedGraph.addAdjacentNode(5, 6);

        disconnectedGraph.printGraph();
        disconnectedGraph.printBreadthFirstTraversalDisconnectedGraph();
    }
}
