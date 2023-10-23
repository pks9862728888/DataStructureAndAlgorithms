package com.practice.programs.revise.medium.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TC: O(2n), AS: O(3n), hash, call stack, result tree
 */
class ConstructBSTFromInorderAndPreOrderTraversal {

    public TreeNode constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeIdxMap.put(inorder[i], i);
        }
        AtomicInteger rootIdx = new AtomicInteger(0);
        return construct(preorder, rootIdx, 0, preorder.length - 1, nodeIdxMap);
    }

    private TreeNode construct(int[] preOrder, AtomicInteger rootIdx, int st, int end, Map<Integer, Integer> nodeIdxMap) {
        if (st > end) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[rootIdx.getAndIncrement()]);
        int rootIdxInorder = nodeIdxMap.get((int) root.val);
        root.left = construct(preOrder, rootIdx, st, rootIdxInorder - 1, nodeIdxMap);
        root.right = construct(preOrder, rootIdx, rootIdxInorder + 1, end, nodeIdxMap);
        return root;
    }

    private class TreeNode {
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
