package com.practice.programs.medium.graphs;

/**
 * TC: O(n * m), AS: O(n * m)
 * <a href="https://www.codingninjas.com/studio/problems/flood-fill-_1082141?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class FloodFill {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static int[][] floodFill(
            int[][] image, int n, int m, int x, int y, int p) {
        floodFill(x, y, n, m, image, p, image[x][y]);
        return image;
    }

    private static void floodFill(int x, int y, int n, int m, int[][] image,
                                  int p, int c) {
        image[x][y] = p;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canFill(nx, ny, n, m, image, c)) {
                floodFill(nx, ny, n, m, image, p, c);
            }
        }
    }

    private static boolean canFill(
            int x, int y, int n, int m, int[][] image, int c) {
        return x >= 0 && y >= 0 && x < n && y < m && image[x][y] == c;
    }
}
