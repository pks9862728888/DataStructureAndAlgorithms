package com.demo.datastructures.impl.graph.algorithms.dijkstrasalgorithm;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class UndirectedWeightedAdjacencyListGraph {

    private int vertex;
    private ArrayList<ArrayList<Edge>> graph;
    UndirectedWeightedAdjacencyListGraph(int vertex) {
        this.vertex = vertex;
        this.graph = new ArrayList<>();
        IntStream.range(0, vertex).forEach(i -> graph.add(new ArrayList<>()));
    }

    public void addToGraph(int v1, int v2, int distance) {
        graph.get(v1).add(new Edge(v2, distance));
        graph.get(v2).add(new Edge(v1, distance));
    }

    public void findMinDistOfAllNodesFromStartVertexUsingDijkstrasAlgorithm() {
        System.out.println("Min distance of all nodes from source node: 0");
        boolean[] visited = new boolean[vertex];
        int[] distance = new int[vertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Find the min distance
        for (int i = 0; i < vertex; i++) {
            int minVertex = findMinDistanceUnvisitedVertex(distance, visited);
            visited[minVertex] = true;

            for (Edge e : graph.get(minVertex)) {
                // If unvisited vertex and
                // dist of vertex > dist of minVertex + dist of neighbour from minVertex
                if (!visited[e.v] && distance[e.v] > distance[minVertex] + e.distance) {
                    distance[e.v] = distance[minVertex] + e.distance;
                }
            }
        }

        // Find min distance of each node from source
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    private int findMinDistanceUnvisitedVertex(int[] distance, boolean[] visited) {
        int mv = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (mv == -1 || distance[i] < distance[mv])) {
                mv = i;
            }
        }
        return mv;
    }

    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + ": ");
            for (Edge e : graph.get(i)) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }

    @AllArgsConstructor
    private static class Edge {
        int v;
        int distance;

        @Override
        public String toString() {
            return "{" +
                    "v=" + v +
                    ", d=" + distance +
                    '}';
        }
    }

}
