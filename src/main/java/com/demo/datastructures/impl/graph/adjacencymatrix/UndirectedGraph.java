package com.demo.datastructures.impl.graph.adjacencymatrix;

import java.lang.reflect.Array;
import java.util.*;

class UndirectedGraph {

    int v;
    int[][] graph;

    UndirectedGraph(int v) {
        this.v = v;
        this.graph = new int[v][v];
    }

    public void linkVertex(int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    /**
     * TC: O(v2)
     */
    public void breadthFirstTraversal() {
        System.out.println("Depth First Traversal: ");
        HashSet<Integer> hs = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        if (graph.length > 0) {
            q.add(0);
        }
        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (hs.add(vertex)) {
                System.out.print(vertex + " ");
                for (int adjNode = 0; adjNode < graph[vertex].length; adjNode++) {
                    if (graph[vertex][adjNode] == 1 && !hs.contains(adjNode)) {
                        q.add(adjNode);
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * TC: O(v2)
     */
    public void depthFirstTraversal() {
        System.out.println("Depth First Traversal: ");
        HashSet<Integer> hs = new HashSet<>();

        if (graph.length > 0) {
            depthFirstTraversal(0, hs);
        }
        System.out.println();
    }

    public void depthFirstTraversal(int vertex, HashSet<Integer> hs) {
        if (hs.add(vertex)) {
            System.out.print(vertex + " ");
            for (int adjNode = 0; adjNode < graph[vertex].length; adjNode++) {
                if (graph[vertex][adjNode] == 1 && !hs.contains(adjNode)) {
                    depthFirstTraversal(adjNode, hs);
                }
            }
        }
    }

    public boolean hasPath(int sourceVertex, int destVertex) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceVertex);

        while (!q.isEmpty()) {
            int vertex = q.remove();
            if (vertex == destVertex) {
                return true;
            }
            visited[vertex] = true;

            for (int adjV = 0; adjV < graph[vertex].length; adjV++) {
                if (graph[vertex][adjV] == 1 && !visited[adjV]) {
                    q.add(adjV);
                }
            }
        }

        return false;
    }

    public ArrayList<Integer> getPathDFS(int sourceVertex, int destVertex) {
        boolean[] visited = new boolean[graph.length];
        return getPathDFS(sourceVertex, destVertex, visited);
    }

    private ArrayList<Integer> getPathDFS(int sourceVertex, int destVertex, boolean[] visited) {
        visited[sourceVertex] = true;
        if (sourceVertex == destVertex) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(sourceVertex);
            return al;
        }
        for (int adjV = 0; adjV < graph[sourceVertex].length; adjV++) {
            if (graph[sourceVertex][adjV] == 1 && !visited[adjV]) {
                ArrayList<Integer> path = getPathDFS(adjV, destVertex, visited);
                if (!path.isEmpty()) {
                    path.add(0, sourceVertex);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }

    /**
     * Get Path using BFS gives the shortest path
     */
    public ArrayList<Integer> getPathBFS(int sourceVertex, int destVertex) {
        boolean[] visited = new boolean[graph.length];
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(sourceVertex, null);
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceVertex);
        boolean found = false;

        while (!q.isEmpty()) {
            int vertex = q.remove();
            visited[vertex] = true;
            if (vertex == destVertex) {
                found = true;
                break;
            }

            for (int adjV = 0; adjV < graph[vertex].length; adjV++) {
                if (graph[vertex][adjV] == 1 && !visited[adjV]) {
                    parentMap.put(adjV, vertex);
                    q.add(adjV);
                    if (adjV == destVertex) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (found) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0, destVertex);
            int currV = destVertex;
            while (parentMap.get(currV) != null) {
                currV = parentMap.get(currV);
                path.add(0, currV);
            }
            return path;
        }

        return new ArrayList<>();
    }

    public boolean isGraphConnected() {
        boolean[] visited = new boolean[graph.length];
        if (graph.length > 0) {
            traverseDepthFirst(0, visited);
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void traverseDepthFirst(int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int adjV = 0; adjV < graph[vertex].length; adjV++) {
            if (graph[vertex][adjV] == 1 && !visited[adjV]) {
                traverseDepthFirst(adjV, visited);
            }
        }
    }

    public void print() {
        for (int[] r : graph) {
            System.out.println(Arrays.toString(r));
        }
    }
}
