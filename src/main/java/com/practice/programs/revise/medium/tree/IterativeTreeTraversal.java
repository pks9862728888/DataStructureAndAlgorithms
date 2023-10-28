package com.practice.programs.revise.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO: Figure of time and space complexity
 * <a href="https://www.codingninjas.com/codestudio/problems/tree-traversal_981269?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class IterativeTreeTraversal {

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(inOrder(root));
        res.add(preOrder(root));
        res.add(postOrder(root));
        return res;
    }

    private static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
        return res;
    }

    private static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.data);
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        return res;
    }

    private static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode temp = st1.pop();
            st2.push(temp.data);

            if (temp.left != null) {
                st1.push(temp.left);
            }
            if (temp.right != null) {
                st1.push(temp.right);
            }
        }
        while (!st2.isEmpty()) {
            res.add(st2.pop());
        }
        return res;
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
