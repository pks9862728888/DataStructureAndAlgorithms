package com.demo.datastructures.tree;

public class TreeDemo {

    public static void main(String[] args) {
        // Create tree
        Tree.NodeT<Integer> root = new Tree.NodeT<>(4);
        Tree.NodeT<Integer> c2 = new Tree.NodeT<>(2);
        Tree.NodeT<Integer> c3 = new Tree.NodeT<>(3);
        Tree.NodeT<Integer> c1 = new Tree.NodeT<>(1);
        Tree.NodeT<Integer> c5 = new Tree.NodeT<>(5);
        Tree.NodeT<Integer> c6 = new Tree.NodeT<>(6);

        root.add(c2);
        root.add(c3);
        root.add(c1);
        c3.add(c5);
        c3.add(c6);

        Tree<Integer> tree = new Tree<>();
//        tree.preOrderTraversal(root);
//        tree.printTree(root);
//        System.out.println("No of nodes in Tree: " + tree.getSize(root));
        Tree.NodeT<Integer> rootFromUserInput = tree.createTree();
        tree.printTree(rootFromUserInput);
    }
}
