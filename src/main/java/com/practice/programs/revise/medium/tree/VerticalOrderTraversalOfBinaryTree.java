package com.practice.programs.revise.medium.tree;

import java.util.*;

/**
 * TC: O(n log n), AS: O(n)
 * TC is n log n, because we are traversing through all the nodes so n, log n because we are using TreeMap
 * <a href="https://www.codingninjas.com/studio/problems/vertical-order-traversal_3622711?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class VerticalOrderTraversalOfBinaryTree {

    public static List<Integer> verticalOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple currTuple = q.poll();
            TreeNode currNode = currTuple.node;
            int x = currTuple.x;
            int y = currTuple.y;

            map.putIfAbsent(x, new TreeMap<>());
            Map<Integer, PriorityQueue<Integer>> yValuesMap = map.get(x);
            yValuesMap.putIfAbsent(y, new PriorityQueue<>());
            yValuesMap.get(currTuple.y).add(currNode.data);
            if (currNode.left != null) {
                q.add(new Tuple(currNode.left, x - 1, y + 1));
            }
            if (currNode.right != null) {
                q.add(new Tuple(currNode.right, x + 1, y + 1));
            }
        }
        // Generate list
        for (Map<Integer, PriorityQueue<Integer>> yValuesMap: map.values()) {
            for (PriorityQueue<Integer> yNodeValues: yValuesMap.values()) {
                while (!yNodeValues.isEmpty()) {
                    res.add(yNodeValues.poll());
                }
            }
        }
        return res;
    }

    private static class Tuple {
        public TreeNode node;
        public int x;
        public int y;
        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
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
