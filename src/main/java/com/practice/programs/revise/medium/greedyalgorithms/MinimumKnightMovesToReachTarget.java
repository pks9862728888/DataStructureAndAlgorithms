package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class MinimumKnightMovesToReachTarget {

    public static void main(String[] args) {
        System.out.println(knightWalk(new int[]{2, 1}, new int[]{8, 5}, 8));
    }

    private static int[][] possibleMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    static int knightWalk(int stPos[], int endPos[], int n) {
        if (isDestReached(stPos[0], stPos[1], endPos)) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(stPos[0], stPos[1], 0));
        Set<String> visited = new HashSet<>();
        visited.add(getKey(stPos[0], stPos[1]));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int[] dm: possibleMoves) {
                int nx = curr.x + dm[0];
                int ny = curr.y + dm[1];
                if (canMove(nx, ny, n, visited)) {
                    if (isDestReached(nx, ny, endPos)) {
                        return curr.moves + 1;
                    }
                    q.add(new Pair(nx, ny, curr.moves + 1));
                    visited.add(getKey(nx, ny));
                }
            }
        }
        return -1;
    }

    private static boolean canMove(int x, int y, int n, Set<String> visited) {
        return x > 0 && y > 0 && x <= n && y <= n && !visited.contains(getKey(x, y));
    }

    private static String getKey(int x, int y) {
        return x + " " + y;
    }

    private static boolean isDestReached(int x, int y, int[] dest) {
        return x == dest[0] && y == dest[1];
    }

    private static class Pair {
        int x;
        int y;
        int moves;
        Pair(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}