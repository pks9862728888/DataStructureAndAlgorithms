package com.practice.programs.revise.medium.graph.directed;

public class FindShortestPathFromOneNodeToAllOtherNodesInGraph {

    /**
     * Find shortest distance from 1 node to all other nodes in graph, -1 denotes not reachable
     * Adjacency matrix is provided in input
     * TC: O(n^3), AS: O(1)
     * <a href="https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1">Practice Link</a>
     * Input:
     *  1  0 43
     *  1  0 6
     * -1 -1 0
     * Output:
     *  0  1 7
     *  1  0 6
     * -1 -1 0
     * Concepts:
     * GRAPH
     * FLOYD_WARSHALLS_ALGORITHM
     */
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        // replace -1 by infinity to indicate no cycle
        replaceMatrix(n, matrix, -1, Integer.MAX_VALUE);
        // Find min cost using floyd warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
        // Do reverse because problem wants -1 in case of no cycle
        replaceMatrix(n, matrix, Integer.MAX_VALUE, -1);
    }

    private void replaceMatrix(int n, int[][] matrix, int target, int replacingValue) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    matrix[i][j] = replacingValue;
                }
            }
        }
    }
}
