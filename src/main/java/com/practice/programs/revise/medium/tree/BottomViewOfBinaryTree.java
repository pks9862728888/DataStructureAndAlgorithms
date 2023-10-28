package com.practice.programs.revise.medium.tree;

import java.util.*;

/**
 * TC: O(n), AS: O(n)
 */
class BottomViewOfBinaryTree {

    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }
        Map<Integer, Integer> eleMap = new HashMap<>();
        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            eleMap.put(curr.idx, curr.node.val);
            maxIdx = Math.max(maxIdx, curr.idx);
            minIdx = Math.min(minIdx, curr.idx);
            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.idx - 1));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.idx + 1));
            }
        }
        for (int i = minIdx; i <= maxIdx; i++) {
            view.add(eleMap.get(i));
        }
        return view;
    }

    private static class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode (int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
