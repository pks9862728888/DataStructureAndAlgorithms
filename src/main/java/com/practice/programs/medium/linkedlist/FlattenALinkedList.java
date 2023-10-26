package com.practice.programs.medium.linkedlist;

/**
 * TC: O(n * n* k), where ‘n’ = size of the linked list and ‘k’ = average number of child nodes for each of the n nodes
 * AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/flatten-a-linked-list_1112655?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FlattenALinkedList {

    public static Node flattenLinkedList(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            Node mergedList = merge(curr, curr.next);
            mergedList.next = curr.next.next;
            curr = mergedList;
        }
        return curr;
    }

    private static Node merge(Node l1, Node l2) {
        Node tHead = new Node(-1);
        Node tail = tHead;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.data <= l2.data) {
                    tail.child = l1;
                    l1 = l1.child;
                } else {
                    tail.child = l2;
                    l2 = l2.child;
                }
            } else if (l1 != null) {
                tail.child = l1;
                l1 = l1.child;
            } else {
                tail.child = l2;
                l2 = l2.child;
            }
            tail = tail.child;
        }
        return tHead.child;
    }

    private static class Node {
        public int data;
        public Node next;
        public Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }
}
