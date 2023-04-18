package com.demo.datastructures.impl.tree.binarytree;

public interface BinaryTreeInterface<T extends Comparable<T>> {

    void add(T ele);

    void preOrderTraversal();

    void postOrderTraversal();

    void inOrderTraversal();

    void levelOrderTraversal();

    void preOrderTraversalRecursively();

    void postOrderTraversalRecursively();

    void inOrderTraversalRecursively();

    int size();

    int height();        // TC: O(n)

    int noOfLeafNodes(); // TC: O(n)

    void printNodesAtDepth(int k); // For depth root node depth = 0, TC = O(n)

    T largestNodeData(); // TC: O(n)

    void removeLeafNodes();

    boolean isBalanced();

    int diameter();

    Node<T> createTreeFromInorderAndPreOrder(T[] inOrder, T[] preOrder);

    Node<T> createTreeFromInorderAndPostOrder(T[] inOrder, T[] postOrder);

    boolean isBST();

    class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
