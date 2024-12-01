package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * TC: O(n), AS: O(1)
 * Concept:
 * LINKED_LIST
 */
class DeleteKthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode left = head;
        ListNode right = head;
        // Move right by (n + 1)th position from left
        for (int idx = 0; idx < n; idx++) {
            right = right.next;
        }
        // If right becomes null, that means first element should be removed
        if (right == null) {
            return head.next;
        }
        // Keep iterating left and right uniformly till it ends of list
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        // Left will be pointing to the previous element which we want to delete
        left.next = left.next.next;
        return head;
    }
}
