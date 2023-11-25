package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;

/**
 * TC: O(n * m), AS: O(n * m)
 */
public class MaxAreaOfAnIsland {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static int maxAreaOfIsland(ArrayList<ArrayList<Integer>> grid){
        int maxArea = 0;
        if (grid.isEmpty()) {
            return maxArea;
        }
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] visited = new boolean[n][m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!visited[x][y] && grid.get(x).get(y) == 1) {
                    maxArea = Math.max(maxArea, visit(x, y, n, m, grid, visited));
                }
            }
        }
        return maxArea;
    }

    public static int visit(int x, int y, int n, int m, ArrayList<ArrayList<Integer>> grid, boolean[][] visited) {
        visited[x][y] = true;
        int connectedNodes = 1;
        for (int dir = 0; dir < dx.length; dir++) {
            int xx = x + dx[dir];
            int yy = y + dy[dir];
            if (canVisit(grid, visited, xx, yy, n, m)) {
                connectedNodes += visit(xx, yy, n, m, grid, visited);
            }
        }
        return connectedNodes;
    }

    public static boolean canVisit(
            ArrayList<ArrayList<Integer>> grid, boolean[][] visited, int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid.get(x).get(y) == 1;
    }
}
