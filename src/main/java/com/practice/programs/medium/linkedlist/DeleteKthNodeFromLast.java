package com.practice.programs.medium.linkedlist;

class DeleteKthNodeFromLast {

    // 3 1 3 2 4, k = 4, 1-indexed
    // ans = 3 3 2 4

    /**
     * TC: O(2n), AS: O(1)
     */
    public static ListNode deleteKthToLast(ListNode head, int k) {
        int len = getLength(head);
        int idxFromStart = len - k;
        if (idxFromStart == 0) { // delete beginning
            return head.next;
        }
        ListNode curr = head;
        while (--idxFromStart > 0) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    };
}
