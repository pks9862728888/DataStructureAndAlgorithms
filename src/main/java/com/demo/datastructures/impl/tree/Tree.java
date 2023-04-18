package com.demo.datastructures.impl.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree<T> {

    public NodeT<Integer> createTree() {
        System.out.println("Enter root node of tree: ");
        Scanner in = new Scanner(System.in);
        int nodeData = in.nextInt();
        if (nodeData == -1) {
            return null;
        }
        NodeT<Integer> root = new NodeT<>(nodeData);
        Queue<NodeT<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            NodeT<Integer> curr = q.poll();
            System.out.println("Enter the childrens for node: " + curr.data);

            while (true) {
                nodeData = in.nextInt();
                if (nodeData == -1) {
                    break;
                }
                NodeT<Integer> child = new NodeT<>(nodeData);
                curr.child.add(child);
                q.add(child);
            }
        }

        in.close();
        return root;
    }

    public void preOrderTraversal(NodeT<T> root) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("Pre-order traversal: ");
        traversePreOrder(root);
        System.out.println();
    }

    private void traversePreOrder(NodeT<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        root.child.forEach(this::traversePreOrder);
    }

    public void printTree(NodeT<T> root) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("Tree: ");
        traversePreOrderCustom(root);
    }

    private void traversePreOrderCustom(NodeT<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        root.child.forEach(node -> System.out.print(node.data + " "));
        System.out.println();
        root.child.forEach(this::traversePreOrderCustom);
    }

    public int getSize(NodeT<T> root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger size = new AtomicInteger(1);
        root.child.forEach(node -> size.getAndAdd(getSize(node)));
        return size.get();
    }

    public static class NodeT<T> {
        T data;
        ArrayList<NodeT<T>> child;

        public NodeT(T data) {
            this.data = data;
            this.child = new ArrayList<>();
        }

        public void add(NodeT<T> node) {
            this.child.add(node);
        }
    }

}
