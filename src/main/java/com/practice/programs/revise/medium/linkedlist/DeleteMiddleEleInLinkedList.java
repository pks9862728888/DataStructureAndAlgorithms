package com.practice.programs.revise.medium.linkedlist;

/**
 * TC: O(n), AS: O(1)
 */
class DeleteMiddleEleInLinkedList {

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    private static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
