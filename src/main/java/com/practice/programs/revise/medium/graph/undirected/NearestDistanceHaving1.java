package com.practice.programs.revise.medium.graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n * m), AS: O(n * m)
 * <a href="https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */

public class NearestDistanceHaving1 {

    // multi-source BFS
    private static final int[] di = {1, 0, -1, 0};
    private static final int[] dj = {0, -1, 0, 1};

    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        initQueueAndResArray(q, res, mat);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int newD = curr.d + 1;
            for (int dir = 0; dir < di.length; dir++) {
                int ii = curr.i + di[dir];
                int jj = curr.j + dj[dir];
                if (canVisit(ii, jj, n, m, res)) {
                    res.get(ii).set(jj, newD);
                    q.add(new Pair(ii, jj, newD));
                }
            }
        }
        return res;
    }

    private static boolean canVisit(
            int i, int j, int n, int m, ArrayList<ArrayList<Integer>> res) {
        return i >= 0 && j >= 0 && i < n && j < m && res.get(i).get(j) == -1;
    }

    private static void initQueueAndResArray(
            Queue<Pair> q, ArrayList<ArrayList<Integer>> res,
            ArrayList<ArrayList<Integer>> mat) {
        for (int i = 0; i < mat.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            res.add(row);
            for (int j = 0; j < mat.get(i).size(); j++) {
                boolean isOne = mat.get(i).get(j) == 1;
                if (isOne) {
                    q.add(new Pair(i, j, 0));
                    row.add(0);
                } else {
                    row.add(-1);
                }
            }
        }
    }

    private static class Pair {
        int i;
        int j;
        int d;

        Pair(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}
