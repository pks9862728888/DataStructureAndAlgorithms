package com.practice.programs.revise.hard.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(n), AS: O(height + n), callStack + auxiliary space for result
 * <a href="https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        findPathPreOrder(root, new StringBuilder(), paths);
        return paths;
    }

    private static void findPathPreOrder(
            TreeNode root, StringBuilder currPath, List<String> paths) {
        boolean isCurrPathEmpty = isEmpty(currPath);
        if (root == null) {
            return;
        }
        int lenNewAppendChars = appendCurrNodeDataToPathString(root, currPath, isCurrPathEmpty);
        if (root.left == null && root.right == null) {
            paths.add(currPath.toString());
        } else {
            findPathPreOrder(root.left, currPath, paths);
            findPathPreOrder(root.right, currPath, paths);
        }
        // Delete curr node value and -> if it was appended
        deleteCharsFromEnd(currPath, lenNewAppendChars);
    }

    private static int appendCurrNodeDataToPathString(
            TreeNode curr, StringBuilder currPath, boolean isCurrPathEmpty) {
        int initialLength = currPath.length();
        if (isCurrPathEmpty) {
            currPath.append(curr.val);
        } else {
            currPath.append("->");
            currPath.append(curr.val);
        }
        return currPath.length() - initialLength;
    }

    private static void deleteCharsFromEnd(StringBuilder sb, int charsToDelete) {
        while (charsToDelete-- > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isEmpty(StringBuilder sb) {
        return sb.length() == 0;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

}
