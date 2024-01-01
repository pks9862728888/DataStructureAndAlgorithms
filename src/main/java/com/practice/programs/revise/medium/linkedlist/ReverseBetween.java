package com.practice.programs.revise.medium.linkedlist;

/**
 * TC: O(2n), AS: O(1)
 */
public class ReverseBetween {

    // [1, 2, 3, 4, 5], left = 2, right = 4
    // ans = [1, 4, 3, 2, 5]

    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode curr = head;

        // Find left
        LinkedListNode prev = null;
        int idx = 1;
        while (curr != null) {
            if (idx == left) {
                break;
            }
            idx++;
            prev = curr;
            curr = curr.next;
        }

        // Find right
        while (curr != null) {
            curr = curr.next;
            if (idx == right) {
                break;
            }
            idx++;
        }

        // Reverse
        LinkedListNode rightNode = curr;
        if (prev == null) {
            head = reverse(head, rightNode);
        } else {
            prev.next = reverse(prev.next, rightNode);
        }
        return head;
    }

    private static LinkedListNode reverse(LinkedListNode curr, LinkedListNode end) {
        LinkedListNode prev = null;
        while (curr != end) {
            LinkedListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            if (temp.next == null) {
                temp.next = end;
            }
        }
        return prev;
    }

    private static final class LinkedListNode {
        public int data;
        public LinkedListNode next;
    }
}
