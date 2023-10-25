package com.practice.programs.easy.linkedlist;

/**
 * TC: O(2n), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/sort-linked-list_625193?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class SortLinkedListSortedInIncreasingAndDecreasingPattern {

    public static Node sortList(Node head) {
        Node h1 = new Node(-1);
        Node t1 = h1;
        Node h2 = null;
        boolean oddPos = true;
        Node curr = head;
        while (curr != null) {
            if (oddPos) {
                t1.next = curr;
                curr = curr.next;
                t1 = t1.next;
            } else {
                Node temp = curr.next;
                curr.next = h2;
                h2 = curr;
                curr = temp;
            }
            oddPos = !oddPos;
        }
        t1.next = null;
        return merge(h1.next, h2);
    }

    private static Node merge(Node h1, Node h2) {
        Node head = new Node(-1);
        Node tail = head;
        while (h1 != null || h2 != null) {
            if (h1 != null && h2 != null) {
                if (h1.data <= h2.data) {
                    tail.next = h1;
                    h1 = h1.next;
                } else {
                    tail.next = h2;
                    h2 = h2.next;
                }
            } else if (h1 != null) {
                tail.next = h1;
                break;
            } else {
                tail.next = h2;
                break;
            }
            tail = tail.next;
        }
        return head.next;
    }

    private static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
