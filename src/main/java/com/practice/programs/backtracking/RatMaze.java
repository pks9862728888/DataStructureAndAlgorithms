package com.practice.programs.backtracking;

import com.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class RatMaze implements Printer {

    public static void main(String[] args) {
        int[][] m = {{1,0,0,0},
                {1,1,1,1},
                {1,0,1,1},
                {1,0,0,1}};
        int n = m.length;
        ArrayList<Node> l = new ArrayList<>();
        if(canReach(m, n, 0, 0, n - 1, n - 1, l)) {
            l.forEach(System.out::println);
        } else {
            System.out.println("Can't reach");
        }
    }

    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, ArrayList<Node> l) {
        return canReach(m, n, sr, sc, n - 1, n - 1, l, new ArrayList<>());
    }

    public static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, ArrayList<Node> l, ArrayList<Node> tn) {
        if (sr == yr && sc == yc) {
            return true;
        } else if (sr > yr && sc > yc) {
            return false;
        }
        boolean reached = false;
        if (isValid(m, sr + 1, sc, n, tn)) { // DOWN
            tn.add(new Node(sr + 1, sc));
            l.add(new Node(sr + 1, sc));
            reached = canReach(m, n, sr + 1, sc, yr, yc, l, tn);
            removeLastIfNotReached(l, reached);
        }
        if (!reached && isValid(m, sr, sc + 1, n, tn)) { // RIGHT
            tn.add(new Node(sr, sc + 1));
            l.add(new Node(sr, sc + 1));
            reached = canReach(m, n, sr, sc + 1, yr, yc, l, tn);
            removeLastIfNotReached(l, reached);
        }
        if (!reached && isValid(m, sr, sc - 1, n, tn)) { // LEFT
            tn.add(new Node(sr, sc - 1));
            l.add(new Node(sr, sc - 1));
            reached = canReach(m, n, sr, sc - 1, yr, yc, l, tn);
            removeLastIfNotReached(l, reached);
        }
        if (!reached && isValid(m, sr - 1, sc, n, tn)) { // UP
            tn.add(new Node(sr - 1, sc));
            l.add(new Node(sr - 1, sc));
            reached = canReach(m, n, sr - 1, sc, yr, yc, l, tn);
            removeLastIfNotReached(l, reached);
        }
        return reached;
    }

    private static void removeLastIfNotReached(ArrayList<Node> l, boolean reached) {
        if (!reached && !l.isEmpty()) {
            l.remove(l.size() - 1);
        }
    }

    private static boolean isValid(int[][] m, int sr, int sc, int n, List<Node> tn) {
        if (sr == n || sc == n) {
            return false;
        } else if (sr < 0 || sc < 0) {
            return false;
        } else if (m[sr][sc] == 1) {
            for (Node nd: tn) {
                if (nd.x == sr && nd.y == sc) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
