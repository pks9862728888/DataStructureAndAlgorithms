package com.practice.programs.revise.medium.linkedlist;

/**
 * TC: O(2n), AS: O(1)
 */
class DeleteKthNodeFromEnd {

    public static Node removeKthNode(Node head, int k) {
        if (head == null) {
            return null;
        } else if (head.next == null && k == 1) {
            return null;
        }
        int len = length(head);
        int posAfterWhichEleShouldBeDeleted = len - k;
        Node prev = head;
        while (prev != null && --posAfterWhichEleShouldBeDeleted != 0) {
            prev = prev.next;
        }
        if (k == len) {
            return head.next;
        } else {
            prev.next = prev.next.next;
            return head;
        }
    }

    private static int length(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
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
