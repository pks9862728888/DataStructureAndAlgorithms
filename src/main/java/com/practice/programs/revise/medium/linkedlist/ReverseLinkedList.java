package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * TC: O(n), AS: O(1)
 * Concepts:
 * LINKED_LIST
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
