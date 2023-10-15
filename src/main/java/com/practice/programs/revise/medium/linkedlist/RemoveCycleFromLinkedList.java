package com.practice.programs.revise.medium.linkedlist;

// TC: O(n), AS: O(1)
class RemoveCycleFromLinkedList {

    // Proof why removal cycle works (Floyds algorithm)
    // If x is the distance from start till intersection
    // d = distance from intersection where slow and fast pointer meet
    // p = remaining dist from point of meet to point of intersection
    // till intersection slow moves by = x + d distance
    // fast moves by = x + 2d + p distance
    // 2 * slow = fast
    // 2 * (x + d) = x + 2d + p
    // x = p (so thats why after cycle detection, we move fast to start and move by 1 along with slow)

    public boolean detectAndRemoveCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycleDetected = false;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycleDetected = true;
                removeCycle(slow, head, slowPrev);
            }
        }
        return isCycleDetected;
    }

    private void removeCycle(ListNode slow, ListNode fast, ListNode slowPrev) {
        while (slow != fast) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        slowPrev.next = null;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; next = null; }
    }
}
