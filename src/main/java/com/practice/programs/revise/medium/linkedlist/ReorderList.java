package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 * TC: O(n)
 * AS: O(1)
 * Concepts:
 * LINKED_LIST
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Find mid
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        // Split list into two halves
        slow.next = null;
        // Reverse second half
        ListNode sh = reverse(mid);
        ListNode fh = head;
        // Join back the split parts
        ListNode resH = new ListNode();
        while (sh != null || fh != null) {
            if (sh != null && fh != null) {
                // Add first
                resH.next = fh;
                resH = fh;
                fh = fh.next;
                // Add second
                resH.next = sh;
                resH = sh;
                sh = sh.next;
                resH.next = null;
            } else {
                resH.next = sh != null ? sh : fh;
                break;
            }
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
