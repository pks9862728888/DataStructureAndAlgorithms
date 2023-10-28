package com.practice.programs.revise.medium.tree;

import java.util.*;

/**
 * TC: O(n), AS: O(3n) - call stack for skewed tree + result array + hashing - using hashing
 * TC: O(n), AS: O(n) - level order elements + result array - using level order traversal
 */
class RightViewOfBinaryTree {

    public ArrayList<Long> rightViewBinaryTree(TreeNode root) {
        // return usingHashing(root);
        return usingLevelOrderTraversal(root);
    }

    private ArrayList<Long> usingLevelOrderTraversal(TreeNode root) {
        ArrayList<Long> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (i + 1 == queueSize) {
                    res.add(curr.val);
                }
            }

        }
        return res;
    }

    private ArrayList<Long> usingHashing(TreeNode root) {
        Map<Long, Long> rightViewMap = new HashMap<>();
        long maxHeight = getHeightAndInitRightViewMap(root, rightViewMap, 0);
        ArrayList<Long> rightView = new ArrayList<>();
        for (long i = 0; i < maxHeight; i++) {
            rightView.add(rightViewMap.get(i));
        }
        return rightView;
    }

    private int getHeightAndInitRightViewMap(
            TreeNode root, Map<Long, Long> rightViewMap, long currDepth) {
        if (root == null) {
            return 0;
        }
        rightViewMap.putIfAbsent(currDepth, root.val);
        int rightHeight = getHeightAndInitRightViewMap(root.right, rightViewMap, currDepth + 1);
        int leftHeight = getHeightAndInitRightViewMap(root.left, rightViewMap, currDepth + 1);
        return 1 + Math.max(leftHeight, rightHeight);
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
