package com.practice.programs.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrderTraversal {

    public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getLevelOrderResNonRecursive(root, res);
        // getLevelOrderOutputRecursivePreOrder(root, res, 0);
        return res;
    }

    /**
     * TC: O(n) AS: O(2^h - 1)
     */
    private void getLevelOrderResNonRecursive(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            List<Integer> levelOrderEle = new ArrayList<>();
            res.add(levelOrderEle);
            int levelOrderEleSize = q.size();
            while (levelOrderEleSize-- > 0) {
                TreeNode curr = q.poll();
                levelOrderEle.add((int) curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    /**
     * TC: O(n), AS: O(h) or O (log n)
     */
    private void getLevelOrderOutputRecursivePreOrder(TreeNode node, List<List<Integer>> res, int depth) {
        if (node == null) {
            return;
        }
        if (res.size() < depth + 1) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add((int) node.val);
        getLevelOrderOutputRecursivePreOrder(node.left, res, depth + 1);
        getLevelOrderOutputRecursivePreOrder(node.right, res, depth + 1);
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
