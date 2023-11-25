package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n*m), SC: O(n*m)
 */
public class TimeTakenToRotAllOranges {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static int rottingOranges(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Item> q = initQueueWithRottenOranges(grid, n, m);
        int timeTaken = 0;
        while (!q.isEmpty()) {
            Item curr = q.poll();
            for (int dir = 0; dir < dx.length; dir++) {
                int x = curr.x + dx[dir];
                int y = curr.y + dy[dir];
                int t = curr.t + 1;

                if (canVisit(x, y, grid, n, m)) {
                    grid[x][y] = 2;
                    timeTaken = Math.max(timeTaken, t);
                    q.add(new Item(x, y, t));
                }
            }
        }

        return anyFreshOrangePending(grid, n, m) ? -1 : timeTaken;
    }

    private static boolean anyFreshOrangePending(int[][] grid, int n, int m) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (grid[x][y] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canVisit(int x, int y, int[][] grid, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }

    public static Queue<Item> initQueueWithRottenOranges(int[][] grid, int n, int m) {
        Queue<Item> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Item(i, j, 0));
                }
            }
        }
        return q;
    }

    private static class Item {
        int x;
        int y;
        int t;

        Item(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
