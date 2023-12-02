package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n*m), SC: O(n*m)
 * <a href="https://www.codingninjas.com/studio/problems/rotting-oranges_701655?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class TimeTakenToRotAllOranges {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static int minTimeToRot(int[][] grid, int n, int m) {
        int minTimeToRot = 0;
        Queue<Pair> rottenOranges = loadRottenOranges(grid, n, m);
        while (!rottenOranges.isEmpty()) {
            Pair pair = rottenOranges.poll();
            for (int dir = 0; dir < dx.length; dir++) {
                int x = pair.x + dx[dir];
                int y = pair.y + dy[dir];
                if (canRot(x, y, n, m, grid)) {
                    grid[x][y] = 2;
                    int timeTakenToRot = pair.timeTaken + 1;
                    minTimeToRot = Math.max(minTimeToRot, timeTakenToRot);
                    rottenOranges.add(new Pair(x, y, timeTakenToRot));
                }
            }
        }
        return isFreshOrangeFound(grid, n, m) ? -1 : minTimeToRot;
    }

    private static boolean canRot(int x, int y, int n, int m, int[][] grid) {
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }

    private static Queue<Pair> loadRottenOranges(int[][] grid, int n, int m) {
        Queue<Pair> rottenOranges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Pair(i, j, 0));
                }
            }
        }
        return rottenOranges;
    }

    private static boolean isFreshOrangeFound(int[][] grid, int n, int m) {
        for (int[] xLine: grid) {
            for (int orange: xLine) {
                if (orange == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Pair {
        int x;
        int y;
        int timeTaken;
        Pair(int x, int y, int timeTaken) {
            this.x = x;
            this.y = y;
            this.timeTaken = timeTaken;
        }
    }
}
