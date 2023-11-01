package com.practice.programs.revise.hard.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(2n), AS: O(height)
 * <a href="https://www.codingninjas.com/studio/problems/print-nodes-at-distance-k-from-a-given-node_842560?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class PrintNodesAtDistanceKFromTarget {

    // Possible cases:
    // curr node is target node and k = 0
    // middle node in tree is target node, so nodes at dist k can be in
    // - left child subtree
    // - right child subtree
    // - parent left / subtree

    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(
            BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int k) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        findNodes(root, target, k, result, -1);
        return result;
    }

    // returns distance from target
    private static int findNodes(
            BinaryTreeNode<Integer> curr, BinaryTreeNode<Integer> target, int k,
            List<BinaryTreeNode<Integer>> result, int distFromTarget) {
        if (curr == null || distFromTarget > k) {
            return -1;
        }
        boolean isCurrTarget = curr == target;
        int distFromTargetToChild;
        if (isCurrTarget) {
            distFromTargetToChild = 1;
        } else {
            distFromTargetToChild = distFromTarget == -1 ? -1 : 1 + distFromTarget;
        }
        int leftDist = findNodes(curr.left, target, k, result, distFromTargetToChild);
        if (leftDist != -1) { // target found in left subtree
            distFromTargetToChild = leftDist + 1;
        }
        int rightDist = findNodes(curr.right, target, k, result, distFromTargetToChild);
        if (rightDist != -1) { // target found in right subtree, so left subtree needs to be traversed again
            findNodes(curr.left, target, k, result, 1 + rightDist);
        }
        int currDist = isCurrTarget ? 0 : -1;

        // Add to result
        addToResultIfKDistApart(currDist, k, curr, result);
        addToResultIfKDistApart(distFromTarget, k, curr, result);
        addToResultIfKDistApart(leftDist, k, curr, result);
        addToResultIfKDistApart(rightDist, k, curr, result);

        // Find distance from target
        if (isCurrTarget) {
            return 1;
        } else if (leftDist != -1) {
            return 1 + leftDist;
        } else if (rightDist != -1) {
            return 1 + rightDist;
        } else {
            return -1;
        }
    }

    private static void addToResultIfKDistApart(
            int currDist, int k, BinaryTreeNode<Integer> curr,
            List<BinaryTreeNode<Integer>> result) {
        if (currDist == k) {
            result.add(curr);
        }
    }

    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }
}
