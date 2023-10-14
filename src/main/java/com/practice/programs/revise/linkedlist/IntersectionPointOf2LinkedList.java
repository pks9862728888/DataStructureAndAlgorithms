package com.practice.programs.revise.linkedlist;

class IntersectionPointOf2LinkedList {

    public static ListNode listIntersectionPoint(ListNode head1, ListNode head2) {
        // Better Option 1: hashing - TC: O(m + n), AS: O(max (m, n))
        // Optimal Option 2: length approach - TC: (m + n), AS: O(1)
        // Optimal Option 3, traversal approach, TC: O(2 * max(m, n)), AS: O(1)
        // return interSectionUsingLengthApproach(head1, head2);
        return intersSectionUsingTraversalApproach(head1, head2);
    }

    private static ListNode intersSectionUsingTraversalApproach(ListNode h1, ListNode h2) {
        ListNode curr1 = h1;
        ListNode curr2 = h2;
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
            if (curr1 == null && curr2 == null) {
                break;
            } else if (curr1 == null) {
                curr1 = h2;
            } else if (curr2 == null) {
                curr2 = h1;
            }
        }
        return null;
    }

    private static ListNode interSectionUsingLengthApproach(ListNode h1, ListNode h2) {
        int l1 = findLength(h1);
        int l2 = findLength(h2);
        int absDiff = Math.abs(l1 - l2);
        if (l1 > l2) {
            h1 = moveByAbsDiff(h1, absDiff);
        } else {
            h2 = moveByAbsDiff(h2, absDiff);
        }
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }

    private static ListNode moveByAbsDiff(ListNode curr, int noOfNodesToMove) {
        while (noOfNodesToMove-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    private static int findLength(ListNode curr) {
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
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
