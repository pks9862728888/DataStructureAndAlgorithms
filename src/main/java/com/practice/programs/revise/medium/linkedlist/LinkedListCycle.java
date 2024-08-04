package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * TC: O(n), AS: O(1)
 * Concepts:
 * LINKED_LIST
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
}
