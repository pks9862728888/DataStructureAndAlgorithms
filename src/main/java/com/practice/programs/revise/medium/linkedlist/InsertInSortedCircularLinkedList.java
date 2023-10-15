package com.practice.programs.revise.medium.linkedlist;

/**
 * TC: O(2n), AS: O(1)
 */
class InsertInSortedCircularLinkedList {

    // 4 5 9 10 0 1 2, insertVal = 7
    // 4 5 7 9 10 0 1 2
    // If list is empty, then return new node

    public ListNode insertIntoSortedCircularList(ListNode head, int insertVal) {
        ListNode newNode = new ListNode(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        head = findMinNode(head);
        if (insertVal <= head.val) { // Insert begin
            insertInBegin(head, newNode);
        } else {
            insertInMiddleOrEnd(head, newNode);
        }
        return newNode;
    }

    private ListNode findMinNode(ListNode head) {
        ListNode minNode = head;
        ListNode curr = head.next;
        while(curr != head) {
            if (curr.val < minNode.val) {
                minNode = curr;
            }
            curr = curr.next;
        }
        return minNode;
    }

    private void insertInMiddleOrEnd(ListNode head, ListNode newNode) {
        // Find node after which insertion should happen
        ListNode smallerNode = head;
        while (newNode.val > smallerNode.next.val) {
            if (smallerNode.next == head) {
                break;
            }
            smallerNode = smallerNode.next;
        }
        newNode.next = smallerNode.next;
        smallerNode.next = newNode;
    }

    private void insertInBegin(ListNode head, ListNode newNode) {
        ListNode lastNode = getLastNode(head.next, head);
        newNode.next = head;
        lastNode.next = newNode;
    }

    private ListNode getLastNode(ListNode curr, ListNode head) {
        ListNode lastNode = curr;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; next = null; }
    }
}
