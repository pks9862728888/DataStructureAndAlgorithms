package com.practice.programs.revise.medium.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TC: O(n), AS: O(n) - call stack in case of skewed BT
 * <a href="https://www.codingninjas.com/studio/problems/maximum-sum-path-of-a-binary-tree._1214968?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class MaximumSumPathOfBinaryTree {

    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger maxSum = new AtomicInteger(root.data);
        findMaxSum(root, maxSum);
        return maxSum.get();
    }

    private static int findMaxSum(BinaryTreeNode<Integer> root, AtomicInteger maxSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = findMaxSum(root.left, maxSum);
        int rightSum =  findMaxSum(root.right, maxSum);
        int currSum = getMaxSum(leftSum, rightSum, root.data);
        if (currSum > maxSum.get()) {
            maxSum.set(currSum);
        }
        // For current max sum
        int currMax = root.data + Math.max(leftSum, rightSum);
        return Math.max(root.data, currMax);
    }

    private static int getMaxSum(int ls, int rs, int rootNodeVal) {
        int fullSum = ls + rs + rootNodeVal;
        int rightOrLeftMaxWithCurrSum = rootNodeVal + Math.max(ls, rs);
        return Math.max(rootNodeVal, Math.max(fullSum, rightOrLeftMaxWithCurrSum));
    }

    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
