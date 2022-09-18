package com.demo.datastructures.graph.adjacencymatrix;

class GraphDemo {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.linkVertex(0, 4);
        graph.linkVertex(0, 2);
        graph.linkVertex(0, 3);
        graph.linkVertex(2, 1);
        graph.linkVertex(1, 5);
        graph.linkVertex(5, 4);
        graph.linkVertex(3, 6);
        graph.print();
        graph.breadthFirstTraversal();
        graph.depthFirstTraversal();
        System.out.println("Has path: 0 -> 5: " + graph.hasPath(0, 5));
        System.out.println("Get path DFS: 0 -> 5: " + graph.getPathDFS(0, 5));
        System.out.println("Get path BFS: 0 -> 5: " + graph.getPathBFS(0, 5));
        System.out.println("Is graph connected? " + graph.isGraphConnected());
    }
}
