package com.practice.programs.revise.algorithms.sorting.linkedlist;

// TC: n log n, AS: O(1) excluding call stack, else O(log n) including call stack
// TC: n log n because, everytime it calls sort list to halve of ll, so log n,
// and find mid / merge operation takes linear time
class MergeSortLinkedList {

    public ListNode sortList(ListNode head) {
        // base
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid, first mid if even
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split ll into two halves
        ListNode head1 = head;
        ListNode head2 = slow.next;

        // Break the linkage between first and second halves
        slow.next = null;

        // Sort first and second halves
        head1 = sortList(head1);
        head2 = sortList(head2);

        // Merge two sorted halves
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    tail.next = head1;
                    head1 = head1.next;
                } else {
                    tail.next = head2;
                    head2 = head2.next;
                }
            } else if (head1 != null) {
                tail.next = head1;
                head1 = head1.next;
            } else if (head2 != null) {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        tail.next = null;
        return res.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
