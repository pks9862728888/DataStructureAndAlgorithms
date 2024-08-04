package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * TC: O(n)
 * AS: O(1)
 * Concepts:
 * LINKED_LIST
 */
public class Merge2SortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            } else if (list1 != null) {
                curr.next = list1;
                break;
            } else {
                curr.next = list2;
                break;
            }
        }
        return head.next;
    }
}
