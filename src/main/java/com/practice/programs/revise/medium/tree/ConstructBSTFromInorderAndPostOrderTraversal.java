package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * TC: O(n), AS: O(n)
 * Concepts:
 * TREE
 * BST
 * CONSTRUCT_BST_FROM_TRAVERSAL
 */
public class ConstructBSTFromInorderAndPostOrderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        AtomicInteger postOrderIdx = new AtomicInteger(postorder.length - 1);
        return build(inorder, postorder, postOrderIdx, 0, inorder.length - 1, idxMap);
    }

    private TreeNode build(
            int[] inorder, int[] postorder, AtomicInteger postOrderIdx, int st, int end, Map<Integer, Integer> idxMap) {
        if (st > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postOrderIdx.getAndDecrement()]);
        int inorderIdx = idxMap.get(root.val);
        root.right = build(inorder, postorder, postOrderIdx, inorderIdx + 1, end, idxMap);
        root.left = build(inorder, postorder, postOrderIdx, st, inorderIdx - 1, idxMap);
        return root;
    }
}
