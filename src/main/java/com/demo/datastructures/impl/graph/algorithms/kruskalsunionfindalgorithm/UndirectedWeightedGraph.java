package com.demo.datastructures.impl.graph.algorithms.kruskalsunionfindalgorithm;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;

class UndirectedWeightedGraph {

    int noOfVertex;
    int e;
    int edgeIdx = 0;
    private Edge[] edgeList;
    public UndirectedWeightedGraph(int noOfVertices, int noOfEdges) {
        this.noOfVertex = noOfVertices;
        this.e = noOfEdges;
        this.edgeList = new Edge[noOfEdges];
    }

    public void addEdge(int v1, int v2, double weight) {
        this.edgeList[edgeIdx++] = new Edge(v1, v2, weight);
    }

    /**
     * No cycle
     * Min sum of weights of edges
     */
    public Edge[] generateMinSpanningTreeUsingKruskalsAndUnionFindAlgorithm() {
        Arrays.sort(edgeList, Comparator.comparingDouble(o -> o.weight));
        Edge[] output = new Edge[noOfVertex - 1];  // length = n - 1
        int outIdx = 0;
        int edgeListIdx = 0;

        // Generate parent array and fill it with self idx
        int[] parentArray = new int[noOfVertex];
        for (int i = 0; i < parentArray.length; i++) {
            parentArray[i] = i;
        }

        while (outIdx < output.length) {
            Edge currentEdge = edgeList[edgeListIdx++];
            int topParentV1 = getTopParent(parentArray, currentEdge.v1);
            int topParentV2 = getTopParent(parentArray, currentEdge.v2);

            if (topParentV1 != topParentV2) {
                // Belong to different component, so safe to add
                output[outIdx++] = currentEdge;

                // Update top parent
                parentArray[topParentV1] = topParentV2;
            }
        }

        // Return edge list
        return output;
    }

    private int getTopParent(int[] parentArray, int vertex) {
        while (vertex != parentArray[vertex]) {
            vertex = parentArray[vertex];
        }
        return vertex;
    }

    @AllArgsConstructor
    @ToString
    public static class Edge {
        int v1;
        int v2;
        double weight;
    }
}
