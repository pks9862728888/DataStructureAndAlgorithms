package com.practice.programs.medium.linkedlist;

class SumNumbersRepresentedInLinkedList {

    /**
     * TC: O(m + n), AS: O(max(m, n))
     */
    public static ListNode sumLists1(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode res = new ListNode(-1);
        ListNode resTail = res;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = 0;
            if (head1 != null && head2 != null) {
                sum += head1.val + head2.val + carry;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 != null) {
                sum += head1.val + carry;
                head1 = head1.next;
            } else {
                sum += head2.val + carry;
                head2 = head2.next;
            }
            carry = sum / 10;
            resTail.next = new ListNode(sum % 10);
            resTail = resTail.next;
        }
        if (carry != 0) {
            resTail.next = new ListNode(carry);
        }
        reverse(head1);
        reverse(head2);
        return reverse(res.next);
    }

    private static ListNode reverse(ListNode curr) {
        if (curr == null || curr.next == null) {
            return curr;
        }
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
