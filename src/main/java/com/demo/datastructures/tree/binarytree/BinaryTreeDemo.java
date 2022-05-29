package com.demo.datastructures.tree.binarytree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(10);
//        bt.inOrderTraversal();
//        bt.postOrderTraversal();
        bt.preOrderTraversal();
//        bt.preOrderTraversalRecursively();
//        bt.levelOrderTraversal();
//        bt.levelOrderTraversalCustomPrint();
//        System.out.println("Size non-recursively: " + bt.size());
//        System.out.println("Size recursively: " + bt.sizeRecursively());
//        bt.postOrderTraversalRecursively();
//        bt.inOrderTraversalRecursively();
//        System.out.println("Largest node data: " + bt.largestNodeData());
//        System.out.println("Max height: " + bt.height());
//        System.out.println("No of leaf nodes: " + bt.noOfLeafNodes());
//        bt.printNodesAtDepth(2);

        // ------------------------------------------
//        System.out.println("Before leaf removal: ");
//        bt.levelOrderTraversalCustomPrint();
//        bt.removeLeafNodes();
//        System.out.println("After leaf removal");
//        bt.levelOrderTraversalCustomPrint();


        // -------------- verify balanced or not
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.add(6);
//        bt.add(4);
//        bt.add(8);
//        bt.add(3);
//        bt.add(5);
//        bt.add(7);
//        bt.add(10);
//        System.out.println("Is bt balanced: " + bt.isBalanced());
//
//        BinaryTree<Integer> bt1 = new BinaryTree<>();
//        bt1.add(6);
//        bt1.add(7);
//        bt1.add(8);
//        bt1.add(9);
//        bt1.add(10);
//        System.out.println("Is bt1 balanced: " + bt1.isBalanced());

        // -----------------------  Diameter
//        BinaryTree<Integer> bt = new BinaryTree<>();  // Expected diameter 8 (between leaf nodes 1 & 8 inclusive of them)
//        bt.add(4);
//        bt.add(3);
//        bt.add(1);
//        bt.add(0);
//        bt.add(2);
//        bt.add(1);
//        bt.add(5);
//        bt.add(6);
//        bt.add(8);
//        bt.add(4);
//        bt.add(5);
//        bt.levelOrderTraversalCustomPrint();
//        System.out.println("Diameter: " + bt.diameter());

        // Create tree using in-order and pre-order traversal
//        testTreeCreationFromInOrderAndPreOrder();

        // Create tree using in-order and post-order traversal
//        testTreeCreationFromInOrderAndPostOrder();
    }

    private static void testTreeCreationFromInOrderAndPreOrder() {
//        // Set 1
        BinaryTree<Integer> bt = new BinaryTree<>();
        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPreOrder(
                new Integer[]{4, 2, 5, 1, 6, 3, 7},  // In-order
                new Integer[]{1, 2, 4, 5, 3, 6, 7}   // Pre-order
        );
        bt.levelOrderTraversalCustomPrint(root);

        // Set 2
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPreOrder(
//                new Integer[]{4, 2, 1, 3, 5},  // In-order
//                new Integer[]{1, 2, 4, 3, 5}   // Pre-order
//        );
//        bt.levelOrderTraversalCustomPrint(root);

        // Set 3
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPreOrder(
//                new Integer[]{1},  // In-order
//                new Integer[]{1}   // Pre-order
//        );
//        bt.levelOrderTraversalCustomPrint(root);
    }

    private static void testTreeCreationFromInOrderAndPostOrder() {
//        // Set 1
        BinaryTree<Integer> bt = new BinaryTree<>();
        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPostOrder(
                new Integer[]{4, 2, 5, 1, 6, 3, 7},  // In-order
                new Integer[]{4, 5, 2, 6, 7, 3, 1}   // Post-order
        );
        bt.levelOrderTraversalCustomPrint(root);

        // Set 2
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPostOrder(
//                new Integer[]{4, 2, 1, 3, 5},  // In-order
//                new Integer[]{4, 2, 5, 3, 1}   // Pre-order
//        );
//        bt.levelOrderTraversalCustomPrint(root);

//        // Set 3
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        BinaryTreeInterface.Node<Integer> root = bt.createTreeFromInorderAndPostOrder(
//                new Integer[]{1},  // In-order
//                new Integer[]{1}   // Pre-order
//        );
//        bt.levelOrderTraversalCustomPrint(root);
    }
}
