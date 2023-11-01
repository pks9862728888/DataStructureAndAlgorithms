package com.practice.programs.easy.bst;

/**
 * TC: O(h), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/insert-into-a-binary-search-tree_1279913?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class InsertNodeInBST {

    public static TreeNode insertionInBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode curr = root;
        while (curr != null) {
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            }
        }
        return root == null ? newNode : root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}
