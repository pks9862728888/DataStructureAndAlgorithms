package com.practice.programs.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(h * 2 * 2 ^ h), AS: O(2 * 2^h), where h = height of binary tree, no of nodes at height h = 2 ^ h
 * <a href="https://www.codingninjas.com/studio/problems/symmetric-tree_981177?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class SymmetricBinaryTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode curr = q.poll();
                elements.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (!isPalindrome(elements)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(List<Integer> l) {
        int n = l.size();
        for (int i = 0; i < n / 2; i++) {
            if (!l.get(i).equals(l.get(n - i - 1))) {
                return false;
            }
        }
        return true;
    }


    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
