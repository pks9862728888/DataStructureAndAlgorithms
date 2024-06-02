package com.practice.programs.medium.tree;

import java.util.LinkedList;
import java.util.List;

public class InorderSuccessorNPredecessorInBinarySearchTree {

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> res = new LinkedList<>();
        res.add(getInOrderPredecessor(root, key));
        res.add(getInOrderSuccessor(root, key));
        return res;
    }

    private static int getInOrderSuccessor(TreeNode root, int key) {
        int res = -1;
        while (root != null) {
            if (key < root.data) {
                res = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    private static int getInOrderPredecessor(TreeNode root, int key) {
        int res = -1;
        while (root != null) {
            if (key > root.data) {
                res = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }

    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }
}
