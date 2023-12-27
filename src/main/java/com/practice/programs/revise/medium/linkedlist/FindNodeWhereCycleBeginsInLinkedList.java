package com.practice.programs.revise.medium.linkedlist;

// TC: O(n), AS: O(1)
public class FindNodeWhereCycleBeginsInLinkedList {

    // Proof why removal cycle works (Floyds algorithm)
    // If x is the distance from start till intersection
    // d = distance from intersection where slow and fast pointer meet
    // p = remaining dist from point of meet to point of intersection
    // till intersection slow moves by = x + d distance
    // fast moves by = x + 2d + p distance
    // 2 * slow = fast
    // 2 * (x + d) = x + 2d + p
    // x = p (so thats why after cycle detection, we move fast to start and move by 1 along with slow)

    public ListNode linkedListCycleII(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return getNodeWhichStartsCycle(slow, head);
            }
        }
        return null;
    }

    private ListNode getNodeWhichStartsCycle(ListNode slow, ListNode fromHead) {
        while (slow != fromHead) {
            slow = slow.next;
            fromHead = fromHead.next;
        }
        return slow;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; next = null; }
    }
}
