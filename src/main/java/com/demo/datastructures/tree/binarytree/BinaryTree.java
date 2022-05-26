package com.demo.datastructures.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    @Override
    public void add(T ele) {
        Node<T> node = new Node<>(ele);
        if (root == null) {
            root = node;
        } else {
            Node<T> curr = root;

            while (true) {
                if (ele.compareTo(curr.data) <= 0) {
                    if (curr.left == null) {
                        curr.left = node;
                        break;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.right == null) {
                        curr.right = node;
                        break;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }
    }

    @Override
    public void preOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        System.out.print("Pre-order traversal: ");
        while (!stack.isEmpty()) {
            Node<T> curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderTraversalRecursively() {
        System.out.print("Pre-order traversal recursively: ");
        preOrderTraversalRecursively(root);
        System.out.println();
    }

    private void preOrderTraversalRecursively(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversalRecursively(node.left);
        preOrderTraversalRecursively(node.right);
    }

    @Override
    public void postOrderTraversalRecursively() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.print("Post order traversal recursively: ");
        postOrderTraversalRecursively(root);
        System.out.println();
    }

    @Override
    public void inOrderTraversalRecursively() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.print("In-order traversal recursively: ");
        inOrderTraversalRecursively(root);
        System.out.println();
    }

    private void inOrderTraversalRecursively(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursively(node.left);
        System.out.print(node.data + " ");
        inOrderTraversalRecursively(node.right);
    }

    private void postOrderTraversalRecursively(Node<T> node) {
        if (node == null) {
            return;
        }
        postOrderTraversalRecursively(node.left);
        postOrderTraversalRecursively(node.right);
        System.out.print(node.data + " ");
    }

    @Override
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
        System.out.print("Level order traversal: ");
        while (!queue.isEmpty()) {
            Node<T> croot = queue.poll();
            Node<T> leftChild = null;
            Node<T> rightChild = null;
            if (!queue.isEmpty()) {
                leftChild = queue.poll();
            }
            if (!queue.isEmpty()) {
                rightChild = queue.poll();
            }

            System.out.print(croot.data + " ");
            if (leftChild != null) {
                System.out.print(leftChild.data + " ");
                if (leftChild.left != null) {
                    queue.add(leftChild.left);
                }
                if (leftChild.right != null) {
                    queue.add(leftChild.right);
                }
            }
            if (rightChild != null) {
                System.out.print(rightChild.data + " ");
                if (rightChild.left != null) {
                    queue.add(rightChild.left);
                }
                if (rightChild.right != null) {
                    queue.add(rightChild.right);
                }
            }
        }
        System.out.println();
    }

    @Override
    public int size() {
        int count = 0;
        if (root != null) {
            Queue<Node<T>> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                count++;
                Node<T> curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return count;
    }

    @Override
    public int height() {
        return height(root, 0);
    }

    private int height(Node<T> node, int maxHeight) {
        if (node == null) {
            return maxHeight;
        }
        return Math.max(height(node.left, maxHeight + 1), height(node.right, maxHeight + 1));
    }

    @Override
    public int noOfLeafNodes() {
        return noOfLeafNodes(root);
    }

    @Override
    public void printNodesAtDepth(int k) {
        if (k >= height() || k < 0) {
            System.out.println("No nodes found at depth: " + k);
            return;
        }
        System.out.print("No of nodes at depth " + k + ": ");
        printNodesAtDepth(root, 0, k);
        System.out.println();
    }

    private void printNodesAtDepth(Node<T> node, int currDepth, int k) {
        if (node == null) {
            return;
        }
        if (currDepth == k) {
            System.out.print(node.data + " ");
        }
        printNodesAtDepth(node.left, currDepth + 1, k);
        printNodesAtDepth(node.right, currDepth + 1, k);
    }

    public int noOfLeafNodes(Node<T> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        }
        return noOfLeafNodes(node.left) + noOfLeafNodes(node.right);
    }

    @Override
    public T largestNodeData() {
        if (root == null) {
            return null;
        }
        return largestNodeData(root, root.data);
    }

    private T largestNodeData(Node<T> node, T largest) {
        if (node == null) {
            return largest;
        }
        if (node.data.compareTo(largest) > 0) {
            largest = node.data;
        }
        largest = largestNodeData(node.left, largest);
        return largestNodeData(node.right, largest);
    }

    @Override
    public void removeLeafNodes() {
        if (root != null && root.left == null && root.right == null) {
            root = null;
        } else {
            removeLeafNodes(root);
        }
    }

    private void removeLeafNodes(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                node.left = null;
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                node.right = null;
            }
        }
        removeLeafNodes(node.left);
        removeLeafNodes(node.right);
    }

    @Override
    public boolean isBalanced() {
        int[] res = isBalanced(root, 1);  // res[0] = balanced or not (1 = balanced), res[1] = garbage determining height
        return res[0] == 1;
    }

    private int[] isBalanced(Node<T> node, int currHeight) {
        if (node == null) {
            return new int[] {1, currHeight};
        }
        int[] leftRes = isBalanced(node.left, currHeight + 1);
        if (leftRes[0] == 0) { // left node unbalanced
            return leftRes;
        } else {
            int[] rightRes = isBalanced(node.right, currHeight + 1);
            if (rightRes[0] == 0) {  // right node unbalanced
                return rightRes;
            }
            // Absolute diff of height of left subtree - right subtree <= 1
            if (Math.abs(leftRes[1] - rightRes[1]) <= 1) {
                return new int[] {1, Math.max(leftRes[1], rightRes[1])};
            } else {
                return new int[] {0, Math.max(leftRes[1], rightRes[1])};
            }
        }
    }

    @Override
    public int diameter() {
        int[] res = diameter(root);
        return res[0] == 0 ? 0 : 1 + res[0]; // 1 + res[0] since diameter counts no of nodes between two furthest nodes
    }

    private int[] diameter(Node<T> node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = diameter(node.left);
        int[] right = diameter(node.right);

        return new int[] {
            Math.max(Math.max(left[0], right[0]), left[1] + right[1]),  // Max diameter between left and right
            1 + Math.max(left[1], right[1])   // Current height at this level
        };
    }

    @Override
    public Node<T> createTreeFromInorderAndPreOrder(T[] inOrder, T[] preOrder) {
        if (inOrder == null || preOrder == null || inOrder.length == 0 || preOrder.length == 0) {
            root = null;
        } else {
            root = createTreeFromInorderAndPreOrder(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
        }
        return root;
    }

    private Node<T> createTreeFromInorderAndPreOrder(T[] inOrder, T[] preOrder, int inorderStIdx, int inorderEndIdx, int preorderStIdx, int preorderEndIdx) {
        if (inorderStIdx < inorderEndIdx && preorderStIdx < preorderEndIdx) {
            // Find current root
            Node<T> root = new Node<>(preOrder[preorderStIdx]);

            // Find root idx from inOrder
            int rootIdxInInOrder = findRootInInOrder(inOrder, inorderStIdx, inorderEndIdx, root.data);

            // Find right and left subtree from in-order
            int leftSubtreeInOrderStIdx = inorderStIdx;
            int leftSubtreeInOrderEndIdx = rootIdxInInOrder - 1;
            int rightSubtreeInOrderStIdx = rootIdxInInOrder + 1;
            int rightSubtreeInOrderEndIdx = inorderEndIdx;

            // Find right and left subtree from pre-order
            int leftSubtreeEleLength = leftSubtreeInOrderEndIdx - inorderStIdx + 1;
            int leftSubtreePreOrderStIdx = preorderStIdx + 1;
            int leftSubtreePreOrderEndIdx = leftSubtreePreOrderStIdx + leftSubtreeEleLength - 1;
            int rightSubtreePreOrderStIdx = leftSubtreePreOrderEndIdx + 1;
            int rightSubtreePreOrderEndIdx = preorderEndIdx;

            // Call recursion & create left and right subtree
            root.left = createTreeFromInorderAndPreOrder(inOrder, preOrder, leftSubtreeInOrderStIdx, leftSubtreeInOrderEndIdx, leftSubtreePreOrderStIdx, leftSubtreePreOrderEndIdx);
            root.right = createTreeFromInorderAndPreOrder(inOrder, preOrder, rightSubtreeInOrderStIdx, rightSubtreeInOrderEndIdx, rightSubtreePreOrderStIdx, rightSubtreePreOrderEndIdx);

            return root;
        } else if (inorderStIdx == inorderEndIdx && preorderStIdx == preorderEndIdx) {
            return new Node<>(inOrder[inorderStIdx]);
        }
        return null;
    }

    @Override
    public Node<T> createTreeFromInorderAndPostOrder(T[] inOrder, T[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length == 0 || postOrder.length == 0) {
            root = null;
        } else {
            root = createTreeFromInorderAndPostOrder(
                    inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
        }
        return root;
    }

    private Node<T> createTreeFromInorderAndPostOrder(
            T[] inOrder, T[] postOrder, int inorderStIdx, int inorderEndIdx, int postorderStIdx, int postorderEndIdx) {
        if (inorderStIdx < inorderEndIdx && postorderStIdx < postorderEndIdx) {
            // Find current root
            Node<T> root = new Node<>(postOrder[postorderEndIdx]);

            // Find root idx from inOrder
            int rootIdxInInOrder = findRootInInOrder(inOrder, inorderStIdx, inorderEndIdx, root.data);

            // Find right and left subtree from in-order
            int leftSubtreeInOrderStIdx = inorderStIdx;
            int leftSubtreeInOrderEndIdx = rootIdxInInOrder - 1;
            int rightSubtreeInOrderStIdx = rootIdxInInOrder + 1;
            int rightSubtreeInOrderEndIdx = inorderEndIdx;

            // Find right and left subtree from pre-order
            int leftSubtreeEleLength = leftSubtreeInOrderEndIdx - inorderStIdx + 1;
            int leftSubtreePostOrderStIdx = postorderStIdx;
            int leftSubtreePostOrderEndIdx = leftSubtreePostOrderStIdx + leftSubtreeEleLength - 1;
            int rightSubtreePostOrderStIdx = leftSubtreePostOrderEndIdx + 1;
            int rightSubtreePostOrderEndIdx = postorderEndIdx - 1;

            // Call recursion & create left and right subtree
            root.left = createTreeFromInorderAndPostOrder(inOrder, postOrder, leftSubtreeInOrderStIdx, leftSubtreeInOrderEndIdx, leftSubtreePostOrderStIdx, leftSubtreePostOrderEndIdx);
            root.right = createTreeFromInorderAndPostOrder(inOrder, postOrder, rightSubtreeInOrderStIdx, rightSubtreeInOrderEndIdx, rightSubtreePostOrderStIdx, rightSubtreePostOrderEndIdx);

            return root;
        } else if (inorderStIdx == inorderEndIdx && postorderStIdx == postorderEndIdx) {
            return new Node<>(inOrder[inorderStIdx]);
        }
        return null;
    }

    private int findRootInInOrder(T[] inOrder, int inorderStIdx, int inorderEndIdx, T data) {
        int idx = -1;
        while (inorderStIdx <= inorderEndIdx) {
            if (inOrder[inorderStIdx].equals(data)) {
                idx = inorderStIdx;
                break;
            }
            inorderStIdx++;
        }
        return idx;
    }

    public int sizeRecursively() {
        return sizeRecursively(root);
    }

    private int sizeRecursively(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursively(node.left) + sizeRecursively(node.right);
    }

    public void levelOrderTraversalCustomPrint() {
        levelOrderTraversalCustomPrint(root);
    }

    public void levelOrderTraversalCustomPrint(Node<T> root) {
        if (root == null) {
            return;
        }
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> node = q.poll();
            System.out.print(node.data + ": ");
            if (node.left != null) {
                System.out.print("L = " + node.left.data);
            }
            if (node.right != null) {
                System.out.print(" R = " + node.right.data);
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            System.out.println();
        }
    }
}
