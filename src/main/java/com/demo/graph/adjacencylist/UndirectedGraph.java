package com.demo.graph.adjacencylist;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class UndirectedGraph {

    ArrayList<ArrayList<Integer>> graph;

    public UndirectedGraph() {
        this.graph = new ArrayList<>();
    }

    public UndirectedGraph(int capacity) {
        this.graph = new ArrayList<>(capacity);
    }

    public void addVertex() {
        this.graph.add(new ArrayList<>());
    }

    public void addVertex(int maxSize) {
        IntStream.range(0, maxSize + 1)
                .forEach(i -> this.graph.add(new ArrayList<>()));
    }

    public void addAdjacentNode(int vertex, int adjacentVertex) {
        this.graph.get(vertex).add(adjacentVertex);
        this.graph.get(adjacentVertex).add(vertex);
    }

    public void printGraph() {
        AtomicInteger ai = new AtomicInteger(0);
        for (ArrayList<Integer> list: graph) {
            System.out.print(ai.getAndIncrement() + " -> ");
            for (Integer ele: list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public void printBreadthFirstTraversal(int startVertex) {
        System.out.println("Breadth First Traversal from start node: " + startVertex);
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        System.out.print(startVertex + " ");
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            ArrayList<Integer> adjacentVertices = graph.get(vertex);

            for (int adjacentVertex: adjacentVertices) {
                if (visited.add(adjacentVertex)) {
                    // Not already printed
                    queue.add(adjacentVertex);
                    System.out.print(adjacentVertex + " ");
                }
            }
        }
        System.out.println();
    }
}
