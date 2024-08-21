package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * TC: O(n), AS: O(n)
 * Concepts:
 * TREE
 */
public class SerializeAndDeserializeBT {

    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                append(sb, NULL);
            } else {
                append(sb, String.valueOf(curr.val));
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, String no) {
        if (sb.length() > 0) sb.append(",");
        sb.append(no);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodeValues = data.split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[idx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            String leftVal = nodeValues[idx++];
            String rightVal = nodeValues[idx++];
            if (!leftVal.equals(NULL)) {
                curr.left = new TreeNode(Integer.parseInt(leftVal));
                q.add(curr.left);
            }
            if (!rightVal.equals(NULL)) {
                curr.right = new TreeNode(Integer.parseInt(rightVal));
                q.add(curr.right);
            }
        }
        return root;
    }
}
