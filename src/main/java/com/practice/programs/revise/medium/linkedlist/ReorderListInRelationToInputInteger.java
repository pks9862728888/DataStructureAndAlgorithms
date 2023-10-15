package com.practice.programs.revise.medium.linkedlist;

class ReorderListInRelationToInputInteger {

    // Reorder such that all ele < x are in left and all ele > x are in right, equal in middle
    // 3 5 8 5 10 2 1, x = 5,
    // res = 3 2 1 5 5 8 10

    public static ListNode partition(ListNode head , int x) {
        ListNode less = new ListNode(-1);
        ListNode equal = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode lessTail = less;
        ListNode equalTail = equal;
        ListNode greaterTail = greater;
        while (head != null) {
            if (head.val > x) {
                greaterTail.next = head;
                greaterTail = head;
            } else if (head.val == x) {
                equalTail.next = head;
                equalTail = head;
            } else if (head.val < x) {
                lessTail.next = head;
                lessTail = head;
            }
            head = head.next;
        }
        lessTail.next = null;
        equalTail.next = null;
        greaterTail.next = null;
        // construct the list
        lessTail.next = equal.next;
        if (lessTail.next == null) {
            lessTail.next = greater.next;
        } else {
            equalTail.next = greater.next;
        }
        return less.next;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; next = null; }
    }
}
