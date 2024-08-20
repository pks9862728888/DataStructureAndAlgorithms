package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * TC: O(n), AS: O(n), BT leaf node width can be n / 2
 * Concept:
 * TREE
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int currDepth = -1;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (currDepth != curr.depth) {
                currDepth = curr.depth;
                res.add(new ArrayList<>());
            }
            List<Integer> currList = res.get(res.size() - 1);
            currList.add(curr.node.val);
            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.depth + 1));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.depth + 1));
            }
        }
        return res;
    }

    private static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
