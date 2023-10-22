package com.practice.programs.revise.medium.tree;

import java.util.*;

/**
 * TC: O(n), AS: O(n)
 */
public class TopViewOfBinaryTree {

    public ArrayList<Long> topViewBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Long> topView = new HashMap<>();
        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            topView.putIfAbsent(curr.distance, curr.node.val);
            minIdx = Math.min(minIdx, curr.distance);
            maxIdx = Math.max(maxIdx, curr.distance);
            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.distance - 1));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.distance + 1));
            }
        }

        // Return result
        ArrayList<Long> res = new ArrayList<>();
        for (int i = minIdx; i <= maxIdx; i++) {
            res.add(topView.get(i));
        }
        return res;
    }

    private static class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    private static class TreeNode {
        public long val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode (long x) {
            val = x;
            left = null;
            right = null;
        }
    }

}
