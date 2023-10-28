package com.practice.programs.revise.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TC: O(2(m + n)), AS: O(2(m + n))
 * <a href="https://www.codingninjas.com/studio/problems/merge-two-bsts_920474?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class MergeTwoBST {

    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> inOrderT1 = new ArrayList<>();
        List<Integer> inOrderT2 = new ArrayList<>();
        inOrder(root1, inOrderT1);
        inOrder(root2, inOrderT2);
        return merge(inOrderT1, inOrderT2);
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.data);
            curr = curr.right;
        }
    }

    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int m = l1.size();
        int n = l2.size();
        while (p1 < m || p2 < n) {
            if (p1 < m && p2 < n) {
                res.add(l1.get(p1) <= l2.get(p2) ? l1.get(p1++) : l2.get(p2++));
            } else if (p1 < m) {
                res.add(l1.get(p1++));
            } else {
                res.add(l2.get(p2++));
            }
        }
        return res;
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
}
