package com.practice.programs.revise.medium.graph.undirected;

/**
 * TC: O(n ^ 2), AS: O(n^2)
 * <a href="https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class FindNoOfProvinces {

    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean[] visited = new boolean[n];
        int provinceCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinceCount++;
                visit(roads, i, n, visited);
            }
        }
        return provinceCount;
    }

    private static void visit(
            int[][] roads, int i, int n, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (roads[i][j] == 1 && !visited[j] && i != j) {
                visit(roads, j, n, visited);
            }
        }
    }

}
