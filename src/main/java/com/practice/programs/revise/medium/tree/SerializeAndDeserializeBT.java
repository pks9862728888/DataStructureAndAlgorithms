package com.practice.programs.revise.medium.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {

    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (sb.length() != 0) {
                sb.append(" ");
            }
            if (curr == null) {
                sb.append("N");
            } else {
                sb.append(curr.key);
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return sb.toString();
    }

    public static Node deserialize(String data) {
        Node root = null;
        String[] arr = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (q.isEmpty()) {
                root = newNode(Integer.parseInt(arr[i]));
                q.add(root);
            } else {
                Node curr = q.poll();
                String left = arr[i];
                String right = arr[++i];
                if (!left.equals("N")) {
                    curr.left = newNode(Integer.parseInt(left));
                    q.add(curr.left);
                }
                if (!right.equals("N")) {
                    curr.right = newNode(Integer.parseInt(right));
                    q.add(curr.right);
                }
            }
        }
        return root;
    }

    static Node newNode(int value) {
        Node n = new Node();
        n.key = value;
        n.left = null;
        n.right = null;
        return n;
    }

    static class Node {
        int key;
        Node left;
        Node right;
    }
}
