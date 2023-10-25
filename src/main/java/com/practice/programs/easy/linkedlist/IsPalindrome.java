package com.practice.programs.easy.linkedlist;

/**
 * TC: O(~4n), AS: O(1)
 */
public class IsPalindrome {

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node prev = null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split linked list
        Node h1 = head;
        prev.next = null;
        Node h2 = reverse(slow);

        // Check palindrome
        boolean isPalindrome = isPalindrome(h1, h2);

        // Re-construct broken linkage and return result
        h2 = reverse(h2);
        prev.next = h2;
        return isPalindrome;
    }

    private static Node reverse(Node curr) {
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static boolean isPalindrome(Node h1, Node h2) {
        while (h1 != null && h2 != null) {
            if (h1.data != h2.data) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
