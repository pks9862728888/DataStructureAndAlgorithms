package com.practice.programs.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/codestudio/problems/create-binary-tree_8360671?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class BinaryTreeRepresentationInJava {

    public static Node createTree(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int arrIdx = 1;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (arrIdx < arr.length && !q.isEmpty()) {
            Node curr = q.poll();
            curr.left = new Node(arr[arrIdx++]);
            q.add(curr.left);
            if (arrIdx < arr.length) {
                curr.right = new Node(arr[arrIdx++]);
                q.add(curr.right);
            }
        }
        return root;
    }

    private static class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
