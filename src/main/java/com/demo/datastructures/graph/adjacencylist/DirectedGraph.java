package com.demo.datastructures.graph.adjacencylist;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class DirectedGraph {

    ArrayList<ArrayList<Integer>> graph;

    public DirectedGraph() {
        this.graph = new ArrayList<>();
    }

    public DirectedGraph(int capacity) {
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

    /**
     * TC: O(v + 2E)
     */
    public void printBreadthFirstTraversalConnectedGraph(int startVertex) {
        System.out.println("Breadth First Traversal from start node: " + startVertex);
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            // Print current vertex
            if (visited.add(vertex)) {
                System.out.print(vertex + " ");
            }

            // Print adjacent vertex
            for (int adjacentVertex: graph.get(vertex)) {
                if (!visited.contains(adjacentVertex)) {
                    // Not already printed
                    queue.add(adjacentVertex);
                    System.out.print(adjacentVertex + " ");
                }
            }
        }
        System.out.println();
    }

    /**
     * TC: O(v + 2E)
     */
    public void printBreadthFirstTraversalDisconnectedGraph() {
        System.out.println("Breadth First Traversal of disconnected graph...");
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.size(); i++) {
            printBreadthFirstTraversal(i, visited);
        }
        System.out.println();
    }

    private void printBreadthFirstTraversal(int startVertex, HashSet<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            // Print current vertex
            if (visited.add(vertex)) {
                System.out.print(vertex + " ");

                // Print adjacent vertex
                for (int adjacentVertex: graph.get(vertex)) {
                    if (visited.add(adjacentVertex)) {
                        // Not already printed
                        queue.add(adjacentVertex);
                        System.out.print(adjacentVertex + " ");
                    }
                }
            }
        }
    }

    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        HashSet<Integer> memo = new HashSet<>();
        for (int i = 0; i < v; i++) {
            Arrays.fill(visited, false);
            if (detectCycleDfs(i, adj, visited, memo)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleDfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                                   HashSet<Integer> memo) {
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;
        for (int i: adj.get(curr)) {
            if (!memo.contains(i) && detectCycleDfs(i, adj, visited, memo)) {
                return true;
            }
            memo.add(i);
            visited[i] = false;
        }

        memo.add(curr);
        return false;
    }
}
