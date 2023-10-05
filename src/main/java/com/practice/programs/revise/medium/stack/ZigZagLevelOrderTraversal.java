package com.practice.programs.revise.medium.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(n), AS: O(n)
 */
class ZigZagLevelOrderTraversal {

    //    1
    //  2   3
    // 4 5 6 7
    // Ans: [[1], [3,2], [4,5,6,7]]

    public List<List<Long>> zigzagLevelOrder(TreeNode root) {
        List<List<Long>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean pushToEnd = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Long> currLevelList = new LinkedList<>();
            res.add(currLevelList);
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                // Add to begin or end
                if (pushToEnd) {
                    currLevelList.add(curr.val);
                } else {
                    currLevelList.add(0, curr.val);
                }
            }
            pushToEnd = !pushToEnd;
        }
        return res;
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
