package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * TC: O(2n), AS: O(1)
 * Concept:
 * LINKED_LIST
 */
class DeleteKthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = findLen(head);
        int idxToRemove = len - n + 1;
        if (idxToRemove == 1) { // if its the first idx
            return head.next;
        } else {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null && --idxToRemove > 0) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null && prev != null) {
                prev.next = curr.next;
                curr.next = null;
            }
            return head;
        }
    }

    private static int findLen(ListNode head) {
        int c = 0;
        while (head != null) {
            head = head.next;
            c++;
        }
        return c;
    }
}
